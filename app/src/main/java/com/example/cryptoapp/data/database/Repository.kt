package com.example.cryptoapp.data.database

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.work.ExistingWorkPolicy
import androidx.work.WorkManager
import com.example.cryptoapp.data.database.mappers.ClassNamesForMappers
import com.example.cryptoapp.data.database.mappers.MappingResult
import com.example.cryptoapp.data.database.mappers.mapListModelLV
import com.example.cryptoapp.data.database.mappers.mapModel
import com.example.cryptoapp.data.database.mappers.mapModelToDomainLV
import com.example.cryptoapp.data.workers.RefreshDataWorker
import com.example.cryptoapp.domain.models.CoinInfDomainModel
import com.example.cryptoapp.domain.models.CryptoRepository

class Repository(private val application: Application) : CryptoRepository {

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

    override fun loadCoinInfoNet() {
        val workManager = WorkManager.getInstance(application)
        workManager.enqueueUniqueWork(
            RefreshDataWorker.NAME,
            ExistingWorkPolicy.REPLACE,
            RefreshDataWorker.makeRequest()
        )
    }
}