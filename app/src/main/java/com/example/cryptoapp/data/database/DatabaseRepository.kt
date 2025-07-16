package com.example.cryptoapp.data.database

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.cryptoapp.data.mappers.mapCoinDBToCoinInfPR
import com.example.cryptoapp.data.mappers.mapDBtoDomainCoinInfLV
import com.example.cryptoapp.data.mappers.mapListCoinInfDBToDomainLV
import com.example.cryptoapp.domain.CryptoDatabase
import com.example.cryptoapp.domain.models.CoinInfDomain

class DatabaseRepository(context: Context) : CryptoDatabase {

    private val database = AppDatabase.getInstance(context)

    override fun getPriceList(): LiveData<List<CoinInfDomain>> {
        return mapListCoinInfDBToDomainLV(database.coinPriceInfoDao().getPriceList())
    }

    override fun getPriceInfoAboutCoin(fSym: String): LiveData<CoinInfDomain> {
        val oldListLV = database.coinPriceInfoDao().getPriceInfoAboutCoin(fSym)
        return mapDBtoDomainCoinInfLV(oldListLV)
    }

    override fun insertPriceList(priceList: List<CoinInfDomain>) {
        val newList = priceList.map {
            mapCoinDBToCoinInfPR(it)
        }
        database.coinPriceInfoDao().insertPriceList(newList)
    }
}