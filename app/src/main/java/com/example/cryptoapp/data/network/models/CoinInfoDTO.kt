package com.example.cryptoapp.data.network.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CoinInfoDTO (
    @SerializedName("CoinInfo")
    @Expose
    val coinsNameDTO: CoinsNameDTO? = null
)
