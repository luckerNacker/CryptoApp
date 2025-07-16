package com.example.cryptoapp.domain

import com.example.cryptoapp.data.pojo.CoinPriceInfo

interface CryptoDatabase {

    fun getTopCoinsInfo(): CoinInfoList

    fun getFullPriceList(): CoinInfoPriceList

    fun insertPriceList(priceList: List<CoinPriceInfo>)
}