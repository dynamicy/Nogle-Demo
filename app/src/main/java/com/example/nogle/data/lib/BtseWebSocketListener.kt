package com.example.nogle.data.lib

import com.example.nogle.common.Constants.Companion.SUBSCRIBE
import com.example.nogle.model.CoinIndexModel
import com.example.nogle.ui.MainViewModel
import com.google.gson.Gson
import okhttp3.Response
import okhttp3.WebSocket
import okhttp3.WebSocketListener

class BtseWebSocketListener(private val viewModel: MainViewModel) : WebSocketListener() {

    override fun onOpen(webSocket: WebSocket, response: Response) {
        super.onOpen(webSocket, response)
        viewModel.setStatus(true)
        webSocket.send(SUBSCRIBE)
    }

    override fun onMessage(webSocket: WebSocket, text: String) {
        super.onMessage(webSocket, text)
        val model = Gson().fromJson(text, CoinIndexModel::class.java)
        model?.data?.apply {
            viewModel.addMessage(this)
        }
    }

    override fun onClosing(webSocket: WebSocket, code: Int, reason: String) {
        super.onClosing(webSocket, code, reason)
    }

    override fun onClosed(webSocket: WebSocket, code: Int, reason: String) {
        super.onClosed(webSocket, code, reason)
        viewModel.setStatus(false)
    }

    override fun onFailure(webSocket: WebSocket, t: Throwable, response: Response?) {
        super.onFailure(webSocket, t, response)
    }
}