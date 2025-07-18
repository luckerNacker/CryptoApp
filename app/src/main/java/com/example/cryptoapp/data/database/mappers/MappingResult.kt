package com.example.cryptoapp.data.database.mappers

import androidx.lifecycle.LiveData
import com.example.cryptoapp.data.database.CoinInfoDatabase
import com.example.cryptoapp.data.network.models.CoinPriceInfoDTO
import com.example.cryptoapp.domain.models.CoinInfDomainModel

sealed class MappingResult {
    data class UIListLV(val data: LiveData<List<CoinPriceInfoDTO>>) : MappingResult()
    data class DomainListLV(val data: LiveData<List<CoinInfDomainModel>>) : MappingResult()
    data class DataListLV(val data: LiveData<List<CoinInfoDatabase>>) : MappingResult()

    data class UIModel(val data: CoinPriceInfoDTO) : MappingResult()
    data class DomainModel(val data: CoinInfDomainModel) : MappingResult()
    data class DataModel(val data: CoinInfoDatabase) : MappingResult()
}