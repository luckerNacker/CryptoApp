package com.example.cryptoapp.data.network.api


import com.example.cryptoapp.data.network.models.CoinInfoListOfData
import com.example.cryptoapp.data.network.models.CoinJsonDTO
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiFactory {

    private const val BASE_URL = "https://min-api.cryptocompare.com/data/"
    const val BASE_IMAGE_URL = "https://cryptocompare.com"

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

    private val apiService = retrofit.create(ApiService::class.java)

    suspend fun getJson(
        fSyms: String,
    ): CoinJsonDTO {
        return apiService.getFullPriceList(fSyms = fSyms)
    }

    suspend fun getTopCoinsInfo(limit: Int = 10): CoinInfoListOfData {
        return apiService.getTopCoinsInfo(limit = limit)
    }
}
