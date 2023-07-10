package com.example.nogle.data.api

import com.example.nogle.common.NetworkResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class BtseRepository @Inject constructor(private val btseService: BtseService) {

    suspend fun getMarkets() = flow {
        emit(NetworkResult.Loading())
        val response = btseService.getMarket().data
        emit(NetworkResult.Success(response))
    }.flowOn(Dispatchers.IO).catch { e -> emit(NetworkResult.Error(e.message ?: "Unknown Error")) }
}
