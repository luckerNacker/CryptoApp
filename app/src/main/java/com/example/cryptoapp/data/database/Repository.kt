package com.example.cryptoapp.data.database

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.cryptoapp.data.network.api.ApiFactory.getJson
import com.example.cryptoapp.data.network.api.ApiFactory.getTopCoinsInfo
import com.example.cryptoapp.data.database.mappers.ClassNamesForMappers
import com.example.cryptoapp.data.database.mappers.MappingResult
import com.example.cryptoapp.data.database.mappers.mapListModelLV
import com.example.cryptoapp.data.database.mappers.mapModel
import com.example.cryptoapp.data.database.mappers.mapModelToDomainLV
import com.example.cryptoapp.data.network.models.CoinJsonDTO
import com.example.cryptoapp.data.network.models.CoinPriceInfoDTO
import com.example.cryptoapp.domain.models.CoinInfDomainModel
import com.example.cryptoapp.domain.models.CryptoRepository
import com.google.gson.Gson
import kotlinx.coroutines.delay

class Repository(application: Application) : CryptoRepository {

    private val database = AppDatabase.getInstance(application).coinPriceInfoDao()

    override fun getPriceList(): LiveData<List<CoinInfDomainModel>> {
        val listData = database.getPriceList()
        val result =
            mapListModelLV(listData, ClassNamesForMappers.DOMAIN) as MappingResult.DomainListLV
        return result.data
    }

    override fun getPriceInfoAboutCoin(fSym: String): LiveData<CoinInfDomainModel> {
        val listData = database.getPriceInfoAboutCoin(fSym)
        return mapModelToDomainLV(listData)
    }

    override suspend fun insertPriceList(priceList: List<CoinInfDomainModel>) {
        val newList = priceList.map {
            (mapModel(it, ClassNamesForMappers.DATA) as MappingResult.DataModel).data
        }
        database.insertPriceList(newList)
    }

    override suspend fun loadCoinInfoNet() {
        while (true) {
            try {
                val disposable = getTopCoinsInfo(limit = 50)
                val names = disposable.data?.map { it.coinsNameDTO?.name }?.joinToString(",") ?: ""
                val json = getJson(names)
                val fullPriceListDB = getPriceListFromJson(json).map {
                    (mapModel(
                        it,
                        ClassNamesForMappers.DATA
                    ) as MappingResult.DataModel).data
                }
                database.insertPriceList(fullPriceListDB)
            } catch (e: Exception) {
            }
            delay(10000)
        }

    }


    private fun getPriceListFromJson(
        coinJsonDTO: CoinJsonDTO
    ): List<CoinPriceInfoDTO> {
        val result = ArrayList<CoinPriceInfoDTO>()
        val jsonObject = coinJsonDTO.coinPriceInfoJsonObject ?: return result
        val coinKeySet = jsonObject.keySet()
        for (coinKey in coinKeySet) {
            val currencyJson = jsonObject.getAsJsonObject(coinKey)
            val currencyKeySet = currencyJson.keySet()
            for (currencyKey in currencyKeySet) {
                val priceInfo = Gson().fromJson(
                    currencyJson.getAsJsonObject(currencyKey),
                    CoinPriceInfoDTO::class.java
                )
                result.add(priceInfo)
            }
        }
        return result
    }

}