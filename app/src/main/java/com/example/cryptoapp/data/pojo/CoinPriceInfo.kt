package com.example.cryptoapp.data.pojo

import com.example.cryptoapp.data.api.ApiFactory.BASE_IMAGE_URL
import com.example.cryptoapp.data.utils.convertTimestampToTime
import com.example.cryptoapp.domain.models.MapperModel
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CoinPriceInfo(
    @SerializedName("TYPE")
    @Expose
    override val type: String?,
    @SerializedName("MARKET")
    @Expose
    override val market: String?,
    @SerializedName("FROMSYMBOL")
    @Expose
    override val fromSymbol: String,
    @SerializedName("TOSYMBOL")
    @Expose
    override val toSymbol: String?,
    @SerializedName("FLAGS")
    @Expose
    override val flags: String?,
    @SerializedName("PRICE")
    @Expose
    override val price: String?,
    @SerializedName("LASTUPDATE")
    @Expose
    override val lastUpdate: Long?,
    @SerializedName("LASTVOLUME")
    @Expose
    override val lastVolume: String?,
    @SerializedName("LASTVOLUMETO")
    @Expose
    override val lastVolumeTo: String?,
    @SerializedName("LASTTRADEID")
    @Expose
    override val lastTradeId: String?,
    @SerializedName("VOLUMEDAY")
    @Expose
    override val volumeDay: String?,
    @SerializedName("VOLUMEDAYTO")
    @Expose
    override val volumeDayTo: String?,
    @SerializedName("VOLUME24HOUR")
    @Expose
    override val volume24Hour: String?,
    @SerializedName("VOLUME24HOURTO")
    @Expose
    override val volume24HourTo: String?,
    @SerializedName("OPENDAY")
    @Expose
    override val openDay: String?,
    @SerializedName("HIGHDAY")
    @Expose
    override val highDay: String?,
    @SerializedName("LOWDAY")
    @Expose
    override val lowDay: String?,
    @SerializedName("OPEN24HOUR")
    @Expose
    override val open24Hour: String?,
    @SerializedName("HIGH24HOUR")
    @Expose
    override val high24Hour: String?,
    @SerializedName("LOW24HOUR")
    @Expose
    override val low24Hour: String?,
    @SerializedName("LASTMARKET")
    @Expose
    override val lastMarket: String?,
    @SerializedName("VOLUMEHOUR")
    @Expose
    override val volumeHour: String?,
    @SerializedName("VOLUMEHOURTO")
    @Expose
    override val volumeHourTo: String?,
    @SerializedName("OPENHOUR")
    @Expose
    override val openHour: String?,
    @SerializedName("HIGHHOUR")
    @Expose
    override val highHour: String?,
    @SerializedName("LOWHOUR")
    @Expose
    override val lowHour: String?,
    @SerializedName("TOPTIERVOLUME24HOUR")
    @Expose
    override val topTierVolume24Hour: String?,
    @SerializedName("TOPTIERVOLUME24HOURTO")
    @Expose
    override val topTierVolume24HourTo: String?,
    @SerializedName("CHANGE24HOUR")
    @Expose
    override val change24Hour: String?,
    @SerializedName("CHANGEPCT24HOUR")
    @Expose
    override val changePCT24Hour: String?,
    @SerializedName("CHANGEDAY")
    @Expose
    override val changeDay: String?,
    @SerializedName("CHANGEPCTDAY")
    @Expose
    override val changePCTDay: String?,
    @SerializedName("SUPPLY")
    @Expose
    override val supply: String?,
    @SerializedName("MKTCAP")
    @Expose
    override val mktCap: String?,
    @SerializedName("TOTALVOLUME24H")
    @Expose
    override val totalVolume24Hour: String?,
    @SerializedName("TOTALVOLUME24HTO")
    @Expose
    override val totalVolume24HourTo: String?,
    @SerializedName("TOTALTOPTIERVOLUME24H")
    @Expose
    override val totalTopTierVolume24Hour: String?,
    @SerializedName("TOTALTOPTIERVOLUME24HTO")
    @Expose
    override val totalTopTierVolume24HourTo: String?,
    @SerializedName("IMAGEURL")
    @Expose
    override val imageUrl: String?
) : MapperModel {
    fun getFormattedTime(): String {
        return convertTimestampToTime(lastUpdate)
    }

    fun getFullImageUrl(): String {
        return BASE_IMAGE_URL + imageUrl
    }
}