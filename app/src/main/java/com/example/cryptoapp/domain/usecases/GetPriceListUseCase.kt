package com.example.cryptoapp.domain.usecases

import androidx.lifecycle.LiveData
import com.example.cryptoapp.domain.CryptoDatabase
import com.example.cryptoapp.domain.models.CoinInfDomain

class GetPriceListUseCase(private val database: CryptoDatabase) {
    operator fun invoke(): LiveData<List<CoinInfDomain>> {
        return database.getPriceList()
    }
}