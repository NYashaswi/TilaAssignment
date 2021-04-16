package com.tila.halloffame.network

import okhttp3.Interceptor
import okhttp3.Response
import java.security.MessageDigest

const val public_key = "_public_key_"
const val private_key = "_private_key_"

class NetworkInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val originalUrl = request.url
        val currentTimeString = System.currentTimeMillis().toString()
        val hash = (currentTimeString+ private_key+ public_key).toMD5()
        val url = originalUrl.newBuilder()
            .addQueryParameter("ts", currentTimeString)
            .addQueryParameter("apikey", public_key)
            .addQueryParameter("hash",hash )
            .build()
        val requestBuilder = request.newBuilder()
            .url(url)
        val newRequest = requestBuilder.build()
        return chain.proceed(newRequest)
    }
    fun String.toMD5(): String {
        val bytes :  ByteArray = MessageDigest.getInstance("MD5").digest(this.toByteArray())
        return bytes.toHex()
    }
    fun ByteArray.toHex(): String {
        return joinToString("") { "%02x".format(it) }
    }
}