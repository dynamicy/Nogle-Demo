package com.example.nogle.model

data class CoinIndexModel (
    val topic: String,
    val id: String?,
    val data: Map<String, CoinIndexDetail>
)

data class CoinIndexDetail(
    val id: String,
    val name: String,
    val type: Int,
    val price: Double,
    val gains: Double,
    val open: Double,
    val high: Double,
    val volume: Double,
    val amount: Double
)
