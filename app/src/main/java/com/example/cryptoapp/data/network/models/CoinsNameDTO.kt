package com.example.cryptoapp.data.network.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CoinsNameDTO (
    @SerializedName("Name")
    @Expose
    val name: String? = null
)
