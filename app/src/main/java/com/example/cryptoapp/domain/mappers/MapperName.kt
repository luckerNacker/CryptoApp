package com.example.cryptoapp.domain.mappers

import com.example.cryptoapp.domain.models.CoinInfoListOfDomain

class MapperName {

    operator fun invoke(coinInfoListOfDomain: CoinInfoListOfDomain): String? {
        val names = coinInfoListOfDomain.data?.map { it.coinInfo?.name }?.joinToString(",")
        return names
    }
}