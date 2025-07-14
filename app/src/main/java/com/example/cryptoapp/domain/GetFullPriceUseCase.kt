package com.example.cryptoapp.domain

class GetFullPriceUseCase(private val database: CryptoDatabase) {
    operator fun invoke(): CoinInfoPriceList {
        return database.getFullPriceList()
    }
}