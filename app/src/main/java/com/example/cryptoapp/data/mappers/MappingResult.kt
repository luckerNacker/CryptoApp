package com.example.cryptoapp.data.mappers

import androidx.lifecycle.LiveData
import com.example.cryptoapp.data.database.CoinInfoDatabase
import com.example.cryptoapp.data.pojo.CoinPriceInfo
import com.example.cryptoapp.domain.models.CoinInfDomainModel

sealed class Mapping {
    data class UIListLV(val data: LiveData<List<CoinPriceInfo>>) : Mapping()
    data class DomainListLV(val data: LiveData<List<CoinInfDomainModel>>) : Mapping()
    data class DataListLV(val data: LiveData<List<CoinInfoDatabase>>) : Mapping()

    data class UIModel(val data: CoinPriceInfo) : Mapping()
    data class DomainModel(val data: CoinInfDomainModel) : Mapping()
    data class DataModel(val data: CoinInfoDatabase) : Mapping()
}