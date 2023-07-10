package com.example.nogle.data.lib

import com.example.nogle.common.Constants
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.WebSocket
import java.util.concurrent.TimeUnit

class BtseWsClient {

    fun getWsClient(listener: BtseWebSocketListener): WebSocket {
        val client = OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .build()
        val request = Request.Builder()
            .url(Constants.WSS_URL)
            .build()
        return client.newWebSocket(request, listener)
    }
}