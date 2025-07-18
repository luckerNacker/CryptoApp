package com.example.cryptoapp.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.cryptoapp.data.database.Repository
import com.example.cryptoapp.domain.usecases.GetInfoAboutCoinUseCase
import com.example.cryptoapp.domain.usecases.GetListUseCase
import com.example.cryptoapp.domain.usecases.LoadCoinInfoNetUseCase

class CoinViewModel(application: Application) : AndroidViewModel(application) {

    private val databaseRepository = Repository(application)

    val coinInfoList = GetListUseCase(databaseRepository).invoke()

    fun getDetailInfo(fSym: String) =
        GetInfoAboutCoinUseCase(databaseRepository).invoke(fSym)

    init {
        loadData()
    }

    private fun loadData() {
        LoadCoinInfoNetUseCase(databaseRepository).invoke()
    }
}