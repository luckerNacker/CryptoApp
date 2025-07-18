package com.example.cryptoapp.domain.usecases

import com.example.cryptoapp.domain.models.CryptoRepository
import com.example.cryptoapp.domain.models.CoinInfDomainModel

class InsertPriceListUseCase(private val database: CryptoRepository) {
    operator fun invoke(priceList: List<CoinInfDomainModel>) {
        database.insertPriceList(priceList)
    }
}