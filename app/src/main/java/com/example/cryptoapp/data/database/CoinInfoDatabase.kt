package com.example.cryptoapp.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.cryptoapp.domain.models.MapperModel

@Entity(tableName = "full_price_list")
data class CoinInfoDatabase(
    override val type: String?,
    override val market: String?,
    @PrimaryKey
    override val fromSymbol: String,
    override val toSymbol: String?,
    override val flags: String?,
    override val price: String?,
    override val lastUpdate: Long?,
    override val lastVolume: String?,
    override val lastVolumeTo: String?,
    override val lastTradeId: String?,
    override val volumeDay: String?,
    override val volumeDayTo: String?,
    override val volume24Hour: String?,
    override val volume24HourTo: String?,
    override val openDay: String?,
    override val highDay: String?,
    override val lowDay: String?,
    override val open24Hour: String?,
    override val high24Hour: String?,
    override val low24Hour: String?,
    override val lastMarket: String?,
    override val volumeHour: String?,
    override val volumeHourTo: String?,
    override val openHour: String?,
    override val highHour: String?,
    override val lowHour: String?,
    override val topTierVolume24Hour: String?,
    override val topTierVolume24HourTo: String?,
    override val change24Hour: String?,
    override val changePCT24Hour: String?,
    override val changeDay: String?,
    override val changePCTDay: String?,
    override val supply: String?,
    override val mktCap: String?,
    override val totalVolume24Hour: String?,
    override val totalVolume24HourTo: String?,
    override val totalTopTierVolume24Hour: String?,
    override val totalTopTierVolume24HourTo: String?,
    override val imageUrl: String?
) : MapperModel