package com.example.cryptoapp.data.mappers

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.example.cryptoapp.data.database.CoinInfoDatabase
import com.example.cryptoapp.data.pojo.CoinPriceInfo
import com.example.cryptoapp.domain.models.CoinInfDomain
import com.example.cryptoapp.domain.models.CoinInfoListOfDomain

fun mapName(coinInfoListOfDomain: CoinInfoListOfDomain): String? {

    return "names"
}

fun mapListCoinDatabaseToCoinInfLV(coinInfoDatabase: LiveData<List<CoinInfoDatabase>>): LiveData<List<CoinPriceInfo>> {
    return coinInfoDatabase.map { databaseList ->
        databaseList.map {
            mapCoinDBToCoinInfPR(it)
        }
    }
}

fun mapCoinDbToCoinInfLV(coinInfoDatabase: LiveData<CoinInfoDatabase>): LiveData<CoinPriceInfo> {
    return coinInfoDatabase.map {
        mapCoinDBToCoinInfPR(it)
    }
}

fun mapCoinDBToCoinInfPR(coinInfoDatabase: CoinInfoDatabase): CoinPriceInfo {
    return CoinPriceInfo(
        type = coinInfoDatabase.type,
        market = coinInfoDatabase.market,
        fromSymbol = coinInfoDatabase.fromSymbol,
        toSymbol = coinInfoDatabase.toSymbol,
        flags = coinInfoDatabase.flags,
        price = coinInfoDatabase.price,
        lastUpdate = coinInfoDatabase.lastUpdate,
        lastVolume = coinInfoDatabase.lastVolume,
        lastVolumeTo = coinInfoDatabase.lastVolumeTo,
        lastTradeId = coinInfoDatabase.lastTradeId,
        volumeDay = coinInfoDatabase.volumeDay,
        volumeDayTo = coinInfoDatabase.volumeDayTo,
        volume24Hour = coinInfoDatabase.volume24Hour,
        volume24HourTo = coinInfoDatabase.volume24HourTo,
        openDay = coinInfoDatabase.openDay,
        highDay = coinInfoDatabase.highDay,
        lowDay = coinInfoDatabase.lowDay,
        open24Hour = coinInfoDatabase.open24Hour,
        high24Hour = coinInfoDatabase.high24Hour,
        low24Hour = coinInfoDatabase.low24Hour,
        lastMarket = coinInfoDatabase.lastMarket,
        volumeHour = coinInfoDatabase.volumeHour,
        volumeHourTo = coinInfoDatabase.volumeHourTo,
        openHour = coinInfoDatabase.openHour,
        highHour = coinInfoDatabase.highHour,
        lowHour = coinInfoDatabase.lowHour,
        topTierVolume24Hour = coinInfoDatabase.topTierVolume24Hour,
        topTierVolume24HourTo = coinInfoDatabase.topTierVolume24HourTo,
        change24Hour = coinInfoDatabase.change24Hour,
        changePCT24Hour = coinInfoDatabase.changePCT24Hour,
        changeDay = coinInfoDatabase.changeDay,
        changePCTDay = coinInfoDatabase.changePCTDay,
        supply = coinInfoDatabase.supply,
        mktCap = coinInfoDatabase.mktCap,
        totalVolume24Hour = coinInfoDatabase.totalVolume24Hour,
        totalVolume24HourTo = coinInfoDatabase.totalVolume24HourTo,
        totalTopTierVolume24Hour = coinInfoDatabase.totalTopTierVolume24Hour,
        totalTopTierVolume24HourTo = coinInfoDatabase.totalTopTierVolume24HourTo,
        imageUrl = coinInfoDatabase.imageUrl
    )
}

fun mapCoinDBToCoinInfPR(coinInfoDatabase: CoinInfDomain): CoinInfoDatabase {
    return CoinInfoDatabase(
        type = coinInfoDatabase.type,
        market = coinInfoDatabase.market,
        fromSymbol = coinInfoDatabase.fromSymbol,
        toSymbol = coinInfoDatabase.toSymbol,
        flags = coinInfoDatabase.flags,
        price = coinInfoDatabase.price,
        lastUpdate = coinInfoDatabase.lastUpdate,
        lastVolume = coinInfoDatabase.lastVolume,
        lastVolumeTo = coinInfoDatabase.lastVolumeTo,
        lastTradeId = coinInfoDatabase.lastTradeId,
        volumeDay = coinInfoDatabase.volumeDay,
        volumeDayTo = coinInfoDatabase.volumeDayTo,
        volume24Hour = coinInfoDatabase.volume24Hour,
        volume24HourTo = coinInfoDatabase.volume24HourTo,
        openDay = coinInfoDatabase.openDay,
        highDay = coinInfoDatabase.highDay,
        lowDay = coinInfoDatabase.lowDay,
        open24Hour = coinInfoDatabase.open24Hour,
        high24Hour = coinInfoDatabase.high24Hour,
        low24Hour = coinInfoDatabase.low24Hour,
        lastMarket = coinInfoDatabase.lastMarket,
        volumeHour = coinInfoDatabase.volumeHour,
        volumeHourTo = coinInfoDatabase.volumeHourTo,
        openHour = coinInfoDatabase.openHour,
        highHour = coinInfoDatabase.highHour,
        lowHour = coinInfoDatabase.lowHour,
        topTierVolume24Hour = coinInfoDatabase.topTierVolume24Hour,
        topTierVolume24HourTo = coinInfoDatabase.topTierVolume24HourTo,
        change24Hour = coinInfoDatabase.change24Hour,
        changePCT24Hour = coinInfoDatabase.changePCT24Hour,
        changeDay = coinInfoDatabase.changeDay,
        changePCTDay = coinInfoDatabase.changePCTDay,
        supply = coinInfoDatabase.supply,
        mktCap = coinInfoDatabase.mktCap,
        totalVolume24Hour = coinInfoDatabase.totalVolume24Hour,
        totalVolume24HourTo = coinInfoDatabase.totalVolume24HourTo,
        totalTopTierVolume24Hour = coinInfoDatabase.totalTopTierVolume24Hour,
        totalTopTierVolume24HourTo = coinInfoDatabase.totalTopTierVolume24HourTo,
        imageUrl = coinInfoDatabase.imageUrl
    )
}

fun mapCoinDomainToCoinInfPR(coinInfDomain: CoinInfDomain): CoinPriceInfo {
    return CoinPriceInfo(
        type = coinInfDomain.type,
        market = coinInfDomain.market,
        fromSymbol = coinInfDomain.fromSymbol,
        toSymbol = coinInfDomain.toSymbol,
        flags = coinInfDomain.flags,
        price = coinInfDomain.price,
        lastUpdate = coinInfDomain.lastUpdate,
        lastVolume = coinInfDomain.lastVolume,
        lastVolumeTo = coinInfDomain.lastVolumeTo,
        lastTradeId = coinInfDomain.lastTradeId,
        volumeDay = coinInfDomain.volumeDay,
        volumeDayTo = coinInfDomain.volumeDayTo,
        volume24Hour = coinInfDomain.volume24Hour,
        volume24HourTo = coinInfDomain.volume24HourTo,
        openDay = coinInfDomain.openDay,
        highDay = coinInfDomain.highDay,
        lowDay = coinInfDomain.lowDay,
        open24Hour = coinInfDomain.open24Hour,
        high24Hour = coinInfDomain.high24Hour,
        low24Hour = coinInfDomain.low24Hour,
        lastMarket = coinInfDomain.lastMarket,
        volumeHour = coinInfDomain.volumeHour,
        volumeHourTo = coinInfDomain.volumeHourTo,
        openHour = coinInfDomain.openHour,
        highHour = coinInfDomain.highHour,
        lowHour = coinInfDomain.lowHour,
        topTierVolume24Hour = coinInfDomain.topTierVolume24Hour,
        topTierVolume24HourTo = coinInfDomain.topTierVolume24HourTo,
        change24Hour = coinInfDomain.change24Hour,
        changePCT24Hour = coinInfDomain.changePCT24Hour,
        changeDay = coinInfDomain.changeDay,
        changePCTDay = coinInfDomain.changePCTDay,
        supply = coinInfDomain.supply,
        mktCap = coinInfDomain.mktCap,
        totalVolume24Hour = coinInfDomain.totalVolume24Hour,
        totalVolume24HourTo = coinInfDomain.totalVolume24HourTo,
        totalTopTierVolume24Hour = coinInfDomain.totalTopTierVolume24Hour,
        totalTopTierVolume24HourTo = coinInfDomain.totalTopTierVolume24HourTo,
        imageUrl = coinInfDomain.imageUrl
    )
}

fun mapListCoinInfDBToDomainLV(coinInfoDatabase: LiveData<List<CoinInfoDatabase>>): LiveData<List<CoinInfDomain>> {
    return coinInfoDatabase.map { list ->
        list.map {
            mapListCoinInfDBToDomainLV(it)
        }
    }
}

fun mapDBtoDomainCoinInfLV(coinInfoDatabase: LiveData<CoinInfoDatabase>): LiveData<CoinInfDomain> {
    return coinInfoDatabase.map {
        mapListCoinInfDBToDomainLV(it)
    }
}

fun mapListCoinInfDBToDomainLV(coinInfoDatabase: CoinInfoDatabase): CoinInfDomain {
    return CoinInfDomain(
        type = coinInfoDatabase.type,
        market = coinInfoDatabase.market,
        fromSymbol = coinInfoDatabase.fromSymbol,
        toSymbol = coinInfoDatabase.toSymbol,
        flags = coinInfoDatabase.flags,
        price = coinInfoDatabase.price,
        lastUpdate = coinInfoDatabase.lastUpdate,
        lastVolume = coinInfoDatabase.lastVolume,
        lastVolumeTo = coinInfoDatabase.lastVolumeTo,
        lastTradeId = coinInfoDatabase.lastTradeId,
        volumeDay = coinInfoDatabase.volumeDay,
        volumeDayTo = coinInfoDatabase.volumeDayTo,
        volume24Hour = coinInfoDatabase.volume24Hour,
        volume24HourTo = coinInfoDatabase.volume24HourTo,
        openDay = coinInfoDatabase.openDay,
        highDay = coinInfoDatabase.highDay,
        lowDay = coinInfoDatabase.lowDay,
        open24Hour = coinInfoDatabase.open24Hour,
        high24Hour = coinInfoDatabase.high24Hour,
        low24Hour = coinInfoDatabase.low24Hour,
        lastMarket = coinInfoDatabase.lastMarket,
        volumeHour = coinInfoDatabase.volumeHour,
        volumeHourTo = coinInfoDatabase.volumeHourTo,
        openHour = coinInfoDatabase.openHour,
        highHour = coinInfoDatabase.highHour,
        lowHour = coinInfoDatabase.lowHour,
        topTierVolume24Hour = coinInfoDatabase.topTierVolume24Hour,
        topTierVolume24HourTo = coinInfoDatabase.topTierVolume24HourTo,
        change24Hour = coinInfoDatabase.change24Hour,
        changePCT24Hour = coinInfoDatabase.changePCT24Hour,
        changeDay = coinInfoDatabase.changeDay,
        changePCTDay = coinInfoDatabase.changePCTDay,
        supply = coinInfoDatabase.supply,
        mktCap = coinInfoDatabase.mktCap,
        totalVolume24Hour = coinInfoDatabase.totalVolume24Hour,
        totalVolume24HourTo = coinInfoDatabase.totalVolume24HourTo,
        totalTopTierVolume24Hour = coinInfoDatabase.totalTopTierVolume24Hour,
        totalTopTierVolume24HourTo = coinInfoDatabase.totalTopTierVolume24HourTo,
        imageUrl = coinInfoDatabase.imageUrl
    )
}

fun mapDomainCoinInfToPRLV(coinInfoDatabase: LiveData<CoinInfDomain>): LiveData<CoinPriceInfo> {
    return coinInfoDatabase.map {
        mapCoinDomainToCoinInfPR(it)
    }
}

fun mapListCoinInfDomainToPRLV(coinInfoDatabaseList: LiveData<List<CoinInfDomain>>): LiveData<List<CoinPriceInfo>> {
    return coinInfoDatabaseList.map { list ->
        list.map {
            mapCoinDomainToCoinInfPR(it)
        }
    }
}
