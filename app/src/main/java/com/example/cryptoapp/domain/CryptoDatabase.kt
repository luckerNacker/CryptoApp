package com.example.cryptoapp.domain

import androidx.lifecycle.LiveData
import com.example.cryptoapp.domain.models.CoinInfDomain

interface CryptoDatabase {

    fun getPriceList(): LiveData<List<CoinInfDomain>>

    fun getPriceInfoAboutCoin(fSym: String): LiveData<CoinInfDomain>

    fun insertPriceList(priceList: List<CoinInfDomain>)
}