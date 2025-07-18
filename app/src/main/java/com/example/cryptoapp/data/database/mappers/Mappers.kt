package com.example.cryptoapp.data.database.mappers

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.example.cryptoapp.data.database.CoinInfoDatabase
import com.example.cryptoapp.data.network.api.ApiFactory.BASE_IMAGE_URL
import com.example.cryptoapp.data.network.models.CoinPriceInfoDTO
import com.example.cryptoapp.domain.models.CoinInfDomainModel
import com.example.cryptoapp.domain.models.MapperModel
import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone

fun <T : MapperModel> mapListModelLV(
    listMapperModel: LiveData<List<T>>,
    resultClass: ClassNamesForMappers
): MappingResult {
    return when (resultClass) {
        ClassNamesForMappers.UI -> MappingResult.UIListLV(
            listMapperModel.map { tList ->
                tList.map {
                    ((mapModel(it, ClassNamesForMappers.UI)) as MappingResult.UIModel).data
                }
            }
        )

        ClassNamesForMappers.DOMAIN -> MappingResult.DomainListLV(
            listMapperModel.map { it ->
                it.map {
                    ((mapModel(it, ClassNamesForMappers.DOMAIN)) as MappingResult.DomainModel).data
                }
            })

        ClassNamesForMappers.DATA -> MappingResult.DataListLV(
            listMapperModel.map { tList ->
                tList.map {
                    ((mapModel(it, ClassNamesForMappers.DATA)) as MappingResult.DataModel).data
                }
            }
        )
    }
}

fun mapModel(mapperModel: MapperModel, resultClass: ClassNamesForMappers): MappingResult {
    Log.d("mapModel", "$resultClass $mapperModel")
    return when (resultClass) {
        ClassNamesForMappers.UI -> MappingResult.UIModel(
            data = CoinPriceInfoDTO(
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

        ClassNamesForMappers.DATA -> MappingResult.DataModel(
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
                imageUrl = BASE_IMAGE_URL + mapperModel.imageUrl
            )
        )

        ClassNamesForMappers.DOMAIN -> MappingResult.DomainModel(
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
        ((mapModel(it, ClassNamesForMappers.DOMAIN)) as MappingResult.DomainModel).data
    }
}


fun convertTimestampToTime(timestamp: Long?): String {
    if (timestamp == null) return ""
    val stamp = Timestamp(timestamp * 1000)
    val date = Date(stamp.time)
    val pattern = "HH:mm:ss"
    val sdf = SimpleDateFormat(pattern, Locale.getDefault())
    sdf.timeZone = TimeZone.getDefault()
    return sdf.format(date)
}

