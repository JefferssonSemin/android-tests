package com.hvn.ci.data

import com.hvn.ci.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

open class BaseApi<T>(clazz: Class<T>) {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.github.com/")
        .client(createOkHttpClient())
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    protected val api = retrofit.create(clazz)

    private fun createOkHttpClient(): OkHttpClient {
        val builder = OkHttpClient.Builder()
            .connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)

        if (BuildConfig.DEBUG) {
            builder.addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        }

        return builder.build()
    }
}