package com.example.numbergame

import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request

object APIUtils {
    private const val BASE_URL = "http://numbersapi.com/"
    private val client = OkHttpClient()

    fun get(endpoint: String, callback: Callback) {
        val url = BASE_URL + endpoint
        val request = Request.Builder()
            .url(url)
            .build()
        client.newCall(request).enqueue(callback)
    }
}
