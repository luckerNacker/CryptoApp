package com.example.cryptoapp.domain

interface CryptoDatabase {

    fun getTopCoinsInfo(): CoinInfoList

    fun getFullPriceList(): CoinInfoPriceList
}