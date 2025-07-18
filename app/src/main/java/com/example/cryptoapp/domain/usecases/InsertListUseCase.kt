package com.example.cryptoapp.domain.usecases

import com.example.cryptoapp.domain.models.CryptoRepository
import com.example.cryptoapp.domain.models.CoinInfDomainModel

class InsertListUseCase(private val database: CryptoRepository) {
    suspend operator fun invoke(priceList: List<CoinInfDomainModel>) {
        database.insertPriceList(priceList)
    }
}