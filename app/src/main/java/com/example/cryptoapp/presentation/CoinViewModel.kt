package com.example.cryptoapp.presentation

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.cryptoapp.data.api.ApiFactory.getFullPriceList
import com.example.cryptoapp.data.api.ApiFactory.getTopCoinsInfo
import com.example.cryptoapp.data.database.DatabaseRepository
import com.example.cryptoapp.data.mappers.mapDomainCoinInfToPRLV
import com.example.cryptoapp.data.mappers.mapListCoinInfDomainToPRLV
import com.example.cryptoapp.data.pojo.CoinPriceInfo
import com.example.cryptoapp.data.pojo.CoinPriceInfoRawData
import com.example.cryptoapp.domain.usecases.GetPriceInfoAboutCoinUseCase
import com.example.cryptoapp.domain.usecases.GetPriceListUseCase
import com.example.cryptoapp.domain.usecases.InsertPriceListUseCase
import com.google.gson.Gson
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class CoinViewModel(application: Application) : AndroidViewModel(application) {

    private val databaseRepository = DatabaseRepository(application)
    private val compositeDisposable = CompositeDisposable()

    val priceList =
        mapListCoinInfDomainToPRLV(GetPriceListUseCase(databaseRepository).invoke())

    fun getDetailInfo(fSym: String): LiveData<CoinPriceInfo> {
        return mapDomainCoinInfToPRLV(
            GetPriceInfoAboutCoinUseCase(databaseRepository).invoke(
                fSym
            )
        )
    }

    init {
        loadData()
    }

    private fun loadData() {
        val disposable = getTopCoinsInfo(limit = 50)
            .map { it.data?.map { it.coinInfo?.name }?.joinToString(",") }
            .flatMap { getFullPriceList(fSyms = it) }
            .map { getPriceListFromRawData(it) }
            .delaySubscription(10, TimeUnit.SECONDS)
            .repeat()
            .retry()
            .subscribeOn(Schedulers.io())
            .subscribe({
                InsertPriceListUseCase(databaseRepository)
                Log.d("TEST_OF_LOADING_DATA", "Success: $it")
            }, {
                Log.d("TEST_OF_LOADING_DATA", "Failure: ${it.message}")
            })
        compositeDisposable.add(disposable)
    }

    private fun getPriceListFromRawData(
        coinPriceInfoRawData: CoinPriceInfoRawData
    ): List<CoinPriceInfo> {
        val result = ArrayList<CoinPriceInfo>()
        val jsonObject = coinPriceInfoRawData.coinPriceInfoJsonObject ?: return result
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

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}