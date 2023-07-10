package com.example.nogle.common

class Constants {
    companion object {
        const val BASE_URL = "https://api.btse.com/"
        const val WSS_URL = "wss://ws.btse.com/ws/futures"

        const val SUBSCRIBE = "{\"op\": \"subscribe\", \"args\": [\"coinIndex\"]}"
    }
}