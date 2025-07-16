package com.example.cryptoapp.domain.usecases

import com.example.cryptoapp.data.pojo.CoinPriceInfo
import com.example.cryptoapp.domain.CryptoDatabase

class InsertPriceListUseCase(private val database: CryptoDatabase) {
    operator fun invoke(priceList: List<CoinPriceInfo>) {
        database.insertPriceList(priceList)
    }
}