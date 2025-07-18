package com.example.cryptoapp.data.database

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.cryptoapp.data.api.ApiFactory.getJson
import com.example.cryptoapp.data.api.ApiFactory.getTopCoinsInfo
import com.example.cryptoapp.data.mappers.ClassNamesForMappers
import com.example.cryptoapp.data.mappers.Mapping
import com.example.cryptoapp.data.mappers.mapListModelLV
import com.example.cryptoapp.data.mappers.mapModel
import com.example.cryptoapp.data.mappers.mapModelToDomainLV
import com.example.cryptoapp.data.pojo.CoinJson
import com.example.cryptoapp.data.pojo.CoinPriceInfo
import com.example.cryptoapp.domain.models.CoinInfDomainModel
import com.example.cryptoapp.domain.models.CryptoRepository
import com.google.gson.Gson
import kotlinx.coroutines.delay

class Repository(application: Application) : CryptoRepository {

    private val database = AppDatabase.getInstance(application).coinPriceInfoDao()

    override fun getPriceList(): LiveData<List<CoinInfDomainModel>> {
        val listData = database.getPriceList()
        val result =
            mapListModelLV(listData, ClassNamesForMappers.DOMAIN) as Mapping.DomainListLV
        return result.data
    }

    override fun getPriceInfoAboutCoin(fSym: String): LiveData<CoinInfDomainModel> {
        val listData = database.getPriceInfoAboutCoin(fSym)
        return mapModelToDomainLV(listData)
    }

    override fun insertPriceList(priceList: List<CoinInfDomainModel>) {
        val newList = priceList.map {
            (mapModel(it, ClassNamesForMappers.DATA) as Mapping.DataModel).data
        }
        database.insertPriceList(newList)
    }

    override suspend fun loadCoinInfoNet() {
        while (true) {
            val disposable = getTopCoinsInfo(limit = 50)
            val names = disposable.data?.map { it.coinsNameDTO?.name }?.joinToString(",") ?: ""
            val json = getJson(names)
            val fullPriceListDB = getPriceListFromJson(json).map {
                (mapModel(
                    it,
                    ClassNamesForMappers.DATA
                ) as Mapping.DataModel).data
            }
            database.insertPriceList(fullPriceListDB)
            delay(10000)
        }

    }


    private fun getPriceListFromJson(
        coinJson: CoinJson
    ): List<CoinPriceInfo> {
        val result = ArrayList<CoinPriceInfo>()
        val jsonObject = coinJson.coinPriceInfoJsonObject ?: return result
        val coinKeySet = jsonObject.keySet()
        for (coinKey in coinKeySet) {
            val currencyJson = jsonObject.getAsJsonObject(coinKey)
            val currencyKeySet = currencyJson.keySet()
            for (currencyKey in currencyKeySet) {
                val priceInfo = Gson().fromJson(
                    currencyJson.getAsJsonObject(currencyKey),
                    CoinPriceInfo::class.java
                )
                result.add(priceInfo)
            }
        }
        return result
    }

}