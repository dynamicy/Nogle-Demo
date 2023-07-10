package com.example.nogle.data.api

import com.example.nogle.model.MarketResponse
import retrofit2.http.GET

interface BtseService {

    @GET("/futures/api/inquire/initial/market")
    suspend fun getMarket(): MarketResponse
}