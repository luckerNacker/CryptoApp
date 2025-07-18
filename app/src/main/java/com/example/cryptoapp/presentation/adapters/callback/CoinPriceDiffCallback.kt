package com.example.cryptoapp.presentation.adapters.callback

import androidx.recyclerview.widget.DiffUtil
import com.example.cryptoapp.domain.models.CoinInfDomainModel

class CoinPriceDiffCallback : DiffUtil.ItemCallback<CoinInfDomainModel>() {
    override fun areItemsTheSame(
        oldItem: CoinInfDomainModel,
        newItem: CoinInfDomainModel
    ): Boolean {
        return oldItem.price == newItem.price
    }

    override fun areContentsTheSame(
        oldItem: CoinInfDomainModel,
        newItem: CoinInfDomainModel
    ): Boolean {
        return oldItem.price == newItem.price
    }

}