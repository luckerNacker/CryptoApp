package com.example.cryptoapp.domain.models

import com.example.cryptoapp.data.pojo.CoinInfo
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CoinInfoDomain(
    val coinInfo: CoinInfDomain? = null
)