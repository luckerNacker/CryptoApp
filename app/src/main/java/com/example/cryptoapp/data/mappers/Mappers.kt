package com.example.cryptoapp.data.mappers

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.example.cryptoapp.data.database.CoinInfoDatabase
import com.example.cryptoapp.data.pojo.CoinPriceInfo
import com.example.cryptoapp.domain.models.MapperModel
import com.example.cryptoapp.domain.models.CoinInfDomainModel

fun <K : MapperModel>mapListModelUIToDomain(coinInfoDatabase: List<K>): List<CoinInfDomainModel> {
    return coinInfoDatabase.map {
        ((mapModel(it, ClassNamesForMappers.DOMAIN)) as Mapping.DomainModel).data
    }
}

fun <T : MapperModel> mapListModelLV(
    listMapperModel: LiveData<List<T>>,
    resultClass: ClassNamesForMappers
): Mapping {
    return when (resultClass) {
        ClassNamesForMappers.UI -> Mapping.UIListLV(
            listMapperModel.map { tList ->
                tList.map {
                    ((mapModel(it, ClassNamesForMappers.UI)) as Mapping.UIModel).data
                }
            }
        )

        ClassNamesForMappers.DOMAIN -> Mapping.DomainListLV(
            listMapperModel.map { it ->
                it.map {
                    ((mapModel(it, ClassNamesForMappers.DOMAIN)) as Mapping.DomainModel).data
                }
            })

        ClassNamesForMappers.DATA -> Mapping.DataListLV(
            listMapperModel.map { tList ->
                tList.map {
                    ((mapModel(it, ClassNamesForMappers.DATA)) as Mapping.DataModel).data
                }
            }
        )
    }
}

fun mapModel(mapperModel: MapperModel, resultClass: ClassNamesForMappers): Mapping {
    Log.d("mapModel", "$resultClass $mapperModel")
    return when (resultClass) {
        ClassNamesForMappers.UI -> Mapping.UIModel(
            data = CoinPriceInfo(
                type = mapperModel.type,
                market = mapperModel.market,
                fromSymbol = mapperModel.fromSymbol,
                toSymbol = mapperModel.toSymbol,
                flags = mapperModel.flags,
                price = mapperModel.price,
                lastUpdate = mapperModel.lastUpdate,
                lastVolume = mapperModel.lastVolume,
                lastVolumeTo = mapperModel.lastVolumeTo,
                lastTradeId = mapperModel.lastTradeId,
                volumeDay = mapperModel.volumeDay,
                volumeDayTo = mapperModel.volumeDayTo,
                volume24Hour = mapperModel.volume24Hour,
                volume24HourTo = mapperModel.volume24HourTo,
                openDay = mapperModel.openDay,
                highDay = mapperModel.highDay,
                lowDay = mapperModel.lowDay,
                open24Hour = mapperModel.open24Hour,
                high24Hour = mapperModel.high24Hour,
                low24Hour = mapperModel.low24Hour,
                lastMarket = mapperModel.lastMarket,
                volumeHour = mapperModel.volumeHour,
                volumeHourTo = mapperModel.volumeHourTo,
                openHour = mapperModel.openHour,
                highHour = mapperModel.highHour,
                lowHour = mapperModel.lowHour,
                topTierVolume24Hour = mapperModel.topTierVolume24Hour,
                topTierVolume24HourTo = mapperModel.topTierVolume24HourTo,
                change24Hour = mapperModel.change24Hour,
                changePCT24Hour = mapperModel.changePCT24Hour,
                changeDay = mapperModel.changeDay,
                changePCTDay = mapperModel.changePCTDay,
                supply = mapperModel.supply,
                mktCap = mapperModel.mktCap,
                totalVolume24Hour = mapperModel.totalVolume24Hour,
                totalVolume24HourTo = mapperModel.totalVolume24HourTo,
                totalTopTierVolume24Hour = mapperModel.totalTopTierVolume24Hour,
                totalTopTierVolume24HourTo = mapperModel.totalTopTierVolume24HourTo,
                imageUrl = mapperModel.imageUrl
            )
        )

        ClassNamesForMappers.DATA -> Mapping.DataModel(
            data = CoinInfoDatabase(
                type = mapperModel.type,
                market = mapperModel.market,
                fromSymbol = mapperModel.fromSymbol,
                toSymbol = mapperModel.toSymbol,
                flags = mapperModel.flags,
                price = mapperModel.price,
                lastUpdate = mapperModel.lastUpdate,
                lastVolume = mapperModel.lastVolume,
                lastVolumeTo = mapperModel.lastVolumeTo,
                lastTradeId = mapperModel.lastTradeId,
                volumeDay = mapperModel.volumeDay,
                volumeDayTo = mapperModel.volumeDayTo,
                volume24Hour = mapperModel.volume24Hour,
                volume24HourTo = mapperModel.volume24HourTo,
                openDay = mapperModel.openDay,
                highDay = mapperModel.highDay,
                lowDay = mapperModel.lowDay,
                open24Hour = mapperModel.open24Hour,
                high24Hour = mapperModel.high24Hour,
                low24Hour = mapperModel.low24Hour,
                lastMarket = mapperModel.lastMarket,
                volumeHour = mapperModel.volumeHour,
                volumeHourTo = mapperModel.volumeHourTo,
                openHour = mapperModel.openHour,
                highHour = mapperModel.highHour,
                lowHour = mapperModel.lowHour,
                topTierVolume24Hour = mapperModel.topTierVolume24Hour,
                topTierVolume24HourTo = mapperModel.topTierVolume24HourTo,
                change24Hour = mapperModel.change24Hour,
                changePCT24Hour = mapperModel.changePCT24Hour,
                changeDay = mapperModel.changeDay,
                changePCTDay = mapperModel.changePCTDay,
                supply = mapperModel.supply,
                mktCap = mapperModel.mktCap,
                totalVolume24Hour = mapperModel.totalVolume24Hour,
                totalVolume24HourTo = mapperModel.totalVolume24HourTo,
                totalTopTierVolume24Hour = mapperModel.totalTopTierVolume24Hour,
                totalTopTierVolume24HourTo = mapperModel.totalTopTierVolume24HourTo,
                imageUrl = mapperModel.imageUrl
            )
        )

        ClassNamesForMappers.DOMAIN -> Mapping.DomainModel(
            data = CoinInfDomainModel(
                type = mapperModel.type,
                market = mapperModel.market,
                fromSymbol = mapperModel.fromSymbol,
                toSymbol = mapperModel.toSymbol,
                flags = mapperModel.flags,
                price = mapperModel.price,
                lastUpdate = mapperModel.lastUpdate,
                lastVolume = mapperModel.lastVolume,
                lastVolumeTo = mapperModel.lastVolumeTo,
                lastTradeId = mapperModel.lastTradeId,
                volumeDay = mapperModel.volumeDay,
                volumeDayTo = mapperModel.volumeDayTo,
                volume24Hour = mapperModel.volume24Hour,
                volume24HourTo = mapperModel.volume24HourTo,
                openDay = mapperModel.openDay,
                highDay = mapperModel.highDay,
                lowDay = mapperModel.lowDay,
                open24Hour = mapperModel.open24Hour,
                high24Hour = mapperModel.high24Hour,
                low24Hour = mapperModel.low24Hour,
                lastMarket = mapperModel.lastMarket,
                volumeHour = mapperModel.volumeHour,
                volumeHourTo = mapperModel.volumeHourTo,
                openHour = mapperModel.openHour,
                highHour = mapperModel.highHour,
                lowHour = mapperModel.lowHour,
                topTierVolume24Hour = mapperModel.topTierVolume24Hour,
                topTierVolume24HourTo = mapperModel.topTierVolume24HourTo,
                change24Hour = mapperModel.change24Hour,
                changePCT24Hour = mapperModel.changePCT24Hour,
                changeDay = mapperModel.changeDay,
                changePCTDay = mapperModel.changePCTDay,
                supply = mapperModel.supply,
                mktCap = mapperModel.mktCap,
                totalVolume24Hour = mapperModel.totalVolume24Hour,
                totalVolume24HourTo = mapperModel.totalVolume24HourTo,
                totalTopTierVolume24Hour = mapperModel.totalTopTierVolume24Hour,
                totalTopTierVolume24HourTo = mapperModel.totalTopTierVolume24HourTo,
                imageUrl = mapperModel.imageUrl
            )
        )
    }
}

fun <T : MapperModel> mapModelToDomainLV(coinInfoDatabase: LiveData<T>): LiveData<CoinInfDomainModel> {
    return coinInfoDatabase.map {
        ((mapModel(it, ClassNamesForMappers.DOMAIN)) as Mapping.DomainModel).data
    }
}

fun mapModelToUILV(coinInfoDatabase: LiveData<CoinInfDomainModel>): LiveData<CoinPriceInfo> {
    return coinInfoDatabase.map {
        ((mapModel(it, ClassNamesForMappers.UI)) as Mapping.UIModel).data
    }
}

