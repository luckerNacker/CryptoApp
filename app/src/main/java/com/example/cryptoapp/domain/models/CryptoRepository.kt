package com.example.cryptoapp.domain.models

import androidx.lifecycle.LiveData

interface CryptoRepository {

    fun getPriceList(): LiveData<List<CoinInfDomainModel>>

    fun getPriceInfoAboutCoin(fSym: String): LiveData<CoinInfDomainModel>

    suspend fun insertPriceList(priceList: List<CoinInfDomainModel>)

    fun loadCoinInfoNet()
}