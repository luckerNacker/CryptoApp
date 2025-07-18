package com.example.cryptoapp.domain.usecases

import androidx.lifecycle.LiveData
import com.example.cryptoapp.domain.models.CryptoRepository
import com.example.cryptoapp.domain.models.CoinInfDomainModel

class GetInfoAboutCoinUseCase(private val database: CryptoRepository) {
    operator fun invoke(fSym: String): LiveData<CoinInfDomainModel> {
        return database.getPriceInfoAboutCoin(fSym)
    }
}