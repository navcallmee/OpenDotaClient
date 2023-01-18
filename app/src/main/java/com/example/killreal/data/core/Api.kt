package com.example.killreal.data.core

import androidx.viewbinding.BuildConfig
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class Api {

    fun <T> makeService(clazz: Class<T>): T = Retrofit.Builder()
        .baseUrl("https://api.opendota.com/api/")
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
        .client(makeOkHttpClient())
        .build()
        .create(clazz)

    private fun makeOkHttpClient(): OkHttpClient {
        val client = OkHttpClient.Builder()
            .readTimeout(15, TimeUnit.SECONDS)
            .connectTimeout(15, TimeUnit.SECONDS)
        if (BuildConfig.DEBUG) {
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY
            client.addInterceptor(logging)
        }
        return client.build()
    }
}