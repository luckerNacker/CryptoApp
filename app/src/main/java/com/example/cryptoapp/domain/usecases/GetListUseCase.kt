package com.example.cryptoapp.domain.usecases

import androidx.lifecycle.LiveData
import com.example.cryptoapp.domain.models.CryptoRepository
import com.example.cryptoapp.domain.models.CoinInfDomainModel

class GetListUseCase(private val database: CryptoRepository) {
    operator fun invoke(): LiveData<List<CoinInfDomainModel>> {
        return database.getPriceList()
    }
}