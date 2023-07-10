package com.example.nogle.model

data class CoinFuncSwitch(
    val walletDeposit: Boolean,
    val walletWithdraw: Boolean,
    val walletTransferToUser: Boolean,
    val walletConvert: Boolean,
    val walletConvertFrom: Boolean,
    val walletTransferToFutures: Boolean,
    val walletOtc: Boolean
)

data class AvailableQuote(
    val id: Int,
    val sortId: Int,
    val name: String,
    val shortName: String,
    val symbol: String,
    val type: Int,
    val status: Int,
    val gmtCreate: Long,
    val gmtModified: Long,
    val decimals: Int,
    val isDefault: Int,
    val minSize: Double,
    val maxSize: Double,
    val increment: Double,
    val isSettlement: Int,
    val depositMin: Double,
    val isStable: Boolean,
    val isQuote: Boolean,
    val isSupportAddressExtension: Boolean,
    val currencyUnitMultiplier: Double?,
    val coinFuncSwitch: CoinFuncSwitch
)

data class Market(
    val marketName: String,
    val active: Boolean,
    val marketClosed: Boolean,
    val matchingDisabled: Boolean,
    val future: Boolean,
    val timeBasedContract: Boolean,
    val openTime: Long,
    val closeTime: Long,
    val startMatching: Long,
    val inactiveTime: Long,
    val sortId: Int,
    val lastUpdate: Long?,
    val symbol: String,
    val quoteCurrency: String,
    val baseCurrency: String,
    val fundingRate: Double,
    val openInterest: Double,
    val openInterestUSD: Double,
    val display: Boolean,
    val displayQuote: String?,
    val globalDisplayQuote: String?,
    val displayOrder: Int,
    val isFavorite: Boolean,
    val initialMarginPercentage: Double,
    val maintenanceMarginPercentage: Double,
    val prediction: Boolean,
    val availableQuotes: List<AvailableQuote>?
)

data class MarketResponse(
    val code: Int,
    val msg: String,
    val time: Long,
    val success: Boolean,
    val data: List<Market>
)