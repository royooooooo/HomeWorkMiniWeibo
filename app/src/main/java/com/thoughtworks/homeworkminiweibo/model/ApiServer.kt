package com.thoughtworks.homeworkminiweibo.model

import com.thoughtworks.homeworkminiweibo.data.Moment
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import java.util.concurrent.TimeUnit

interface ApiService {
    companion object {
        private const val BASE_URL = "http://10.0.2.2:3000"

        @Volatile
        private var retrofit: ApiService? = null
        fun getInstance(): ApiService {
            return retrofit ?: synchronized(this) {
                retrofit ?: initApiServer().also { retrofit = it }
            }
        }

        private fun initApiServer(): ApiService {
            val clientBuilder = OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(clientBuilder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService::class.java)
        }
    }

    @GET("/moment")
    fun getMoment(): Call<List<Moment>>
}