package com.example.cryptoapp.domain.usecases

import com.example.cryptoapp.domain.CoinInfoList
import com.example.cryptoapp.domain.CryptoDatabase

class GetTopCoinsInfoUseCase(private val database: CryptoDatabase) {
    operator fun invoke(): CoinInfoList {
        return database.getTopCoinsInfo()
    }
}