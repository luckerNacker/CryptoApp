package com.example.cryptoapp.data.workers

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.OneTimeWorkRequest
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkerParameters
import com.example.cryptoapp.data.database.AppDatabase
import com.example.cryptoapp.data.database.mappers.ClassNamesForMappers
import com.example.cryptoapp.data.database.mappers.MappingResult
import com.example.cryptoapp.data.database.mappers.mapModel
import com.example.cryptoapp.data.network.api.ApiFactory.getJson
import com.example.cryptoapp.data.network.api.ApiFactory.getTopCoinsInfo
import com.example.cryptoapp.data.network.models.CoinJsonDTO
import com.example.cryptoapp.data.network.models.CoinPriceInfoDTO
import com.google.gson.Gson

class RefreshDataWorker(
    context: Context,
    workerParameters: WorkerParameters
) : CoroutineWorker(context, workerParameters) {

    private val database = AppDatabase.getInstance(context).coinPriceInfoDao()
    override suspend fun doWork(): Result {
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

    companion object {
        const val NAME = "RefreshDataWorker"

        fun makeRequest(): OneTimeWorkRequest {
            return OneTimeWorkRequestBuilder<RefreshDataWorker>().build()
        }
    }
}