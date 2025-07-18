package com.example.cryptoapp.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.cryptoapp.data.database.Repository
import com.example.cryptoapp.data.mappers.ClassNamesForMappers
import com.example.cryptoapp.data.mappers.Mapping
import com.example.cryptoapp.data.mappers.mapListModelLV
import com.example.cryptoapp.data.mappers.mapModelToUILV
import com.example.cryptoapp.data.pojo.CoinPriceInfo
import com.example.cryptoapp.domain.usecases.GetPriceInfoAboutCoinUseCase
import com.example.cryptoapp.domain.usecases.GetPriceListUseCase
import io.reactivex.disposables.CompositeDisposable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CoinViewModel(application: Application) : AndroidViewModel(application) {

    private val databaseRepository = Repository(application)
    private val compositeDisposable = CompositeDisposable()
    val coroutine = CoroutineScope(Dispatchers.IO)

    val priceList =
        ((mapListModelLV(
            GetPriceListUseCase(databaseRepository).invoke(),
            ClassNamesForMappers.UI
        )) as Mapping.UIListLV).data

    fun getDetailInfo(fSym: String): LiveData<CoinPriceInfo> {
        return mapModelToUILV(
            GetPriceInfoAboutCoinUseCase(databaseRepository).invoke(
                fSym
            )
        )
    }

    init {
        loadData()
    }

    private fun loadData() {
        coroutine.launch {
            databaseRepository.loadCoinInfoNet()
        }
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}