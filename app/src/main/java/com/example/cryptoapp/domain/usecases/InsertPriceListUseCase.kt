package com.example.cryptoapp.domain.usecases

import com.example.cryptoapp.domain.CryptoDatabase
import com.example.cryptoapp.domain.models.CoinInfDomain

class InsertPriceListUseCase(private val database: CryptoDatabase) {
    operator fun invoke(priceList: List<CoinInfDomain>) {
        database.insertPriceList(priceList)
    }
}