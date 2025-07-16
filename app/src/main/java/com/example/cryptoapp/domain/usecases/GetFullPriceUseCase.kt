package com.example.cryptoapp.domain.usecases

import com.example.cryptoapp.domain.CoinInfoPriceList
import com.example.cryptoapp.domain.CryptoDatabase

class GetFullPriceUseCase(private val database: CryptoDatabase) {
    operator fun invoke(): CoinInfoPriceList {
        return database.getFullPriceList()
    }
}