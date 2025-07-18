package com.example.cryptoapp.data.database

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.cryptoapp.data.mappers.ClassNamesForMappers
import com.example.cryptoapp.data.mappers.Mapping
import com.example.cryptoapp.data.mappers.mapListModelLV
import com.example.cryptoapp.data.mappers.mapModel
import com.example.cryptoapp.data.mappers.mapModelToDomainLV
import com.example.cryptoapp.domain.models.CryptoRepository
import com.example.cryptoapp.domain.models.CoinInfDomainModel

class RepositoryRepository(context: Context) : CryptoRepository {

    private val database = AppDatabase.getInstance(context)

    override fun getPriceList(): LiveData<List<CoinInfDomainModel>> {
        val listData = database.coinPriceInfoDao().getPriceList()
        val result =
            mapListModelLV(listData, ClassNamesForMappers.DOMAIN) as Mapping.DomainListLV
        return result.data
    }

    override fun getPriceInfoAboutCoin(fSym: String): LiveData<CoinInfDomainModel> {
        val listData = database.coinPriceInfoDao().getPriceInfoAboutCoin(fSym)
        return mapModelToDomainLV(listData)
    }

    override fun insertPriceList(priceList: List<CoinInfDomainModel>) {
        val newList = priceList.map {
            (mapModel(it, ClassNamesForMappers.DOMAIN) as Mapping.DataModel).data
        }
        database.coinPriceInfoDao().insertPriceList(newList)
    }
}