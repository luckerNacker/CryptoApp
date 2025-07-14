package com.example.cryptoapp.data.callback

import androidx.recyclerview.widget.DiffUtil
import com.example.cryptoapp.data.pojo.CoinPriceInfo

class CoinPriceDiffCallback : DiffUtil.ItemCallback<CoinPriceInfo>() {
    override fun areItemsTheSame(oldItem: CoinPriceInfo, newItem: CoinPriceInfo): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: CoinPriceInfo, newItem: CoinPriceInfo): Boolean {
        return oldItem.price == newItem.price
    }

}