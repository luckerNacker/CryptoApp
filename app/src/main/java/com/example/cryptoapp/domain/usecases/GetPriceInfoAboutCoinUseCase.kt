package com.example.cryptoapp.domain.usecases

import androidx.lifecycle.LiveData
import com.example.cryptoapp.domain.CryptoDatabase
import com.example.cryptoapp.domain.models.CoinInfDomain

class GetPriceInfoAboutCoinUseCase(private val database: CryptoDatabase) {
    operator fun invoke(fSym: String): LiveData<CoinInfDomain> {
        return database.getPriceInfoAboutCoin(fSym)
    }
}