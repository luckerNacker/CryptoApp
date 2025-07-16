package com.example.cryptoapp.data.api

import com.example.cryptoapp.data.pojo.CoinInfoListOfData
import com.example.cryptoapp.data.pojo.CoinPriceInfoRawData
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object ApiFactory {

    private const val CURRENCY = "USD"
    private const val BASE_URL = "https://min-api.cryptocompare.com/data/"
    const val BASE_IMAGE_URL = "https://cryptocompare.com"

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .baseUrl(BASE_URL)
        .build()

    private val apiService = retrofit.create(ApiService::class.java)

    fun getFullPriceList(
        fSyms: String,
    ): Single<CoinPriceInfoRawData> {
        return apiService.getFullPriceList(fSyms = fSyms)
    }

    fun getTopCoinsInfo(limit: Int = 10,): Single<CoinInfoListOfData> {
        return apiService.getTopCoinsInfo(limit = limit)
    }
}
