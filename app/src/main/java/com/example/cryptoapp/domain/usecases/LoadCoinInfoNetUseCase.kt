package com.example.cryptoapp.domain.usecases

import com.example.cryptoapp.domain.models.CryptoRepository

class LoadCoinInfoNetUseCase(private val database: CryptoRepository) {
    suspend operator fun invoke() {
        database.loadCoinInfoNet()
    }
}