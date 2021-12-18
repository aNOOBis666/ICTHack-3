package com.length.icthack3.models

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient{
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BaseClient.baseUrl)
        .client(BaseClient.okHttpClient)

        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val service: ApiService = retrofit.create(ApiService::class.java)
}