package com.example.cryptoapp.domain

class GetTopCoinsInfoUseCase(private val database: CryptoDatabase) {
    operator fun invoke(): CoinInfoList {
        return database.getTopCoinsInfo()
    }
}