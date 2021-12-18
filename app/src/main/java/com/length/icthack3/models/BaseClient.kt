package com.length.icthack3.models

import okhttp3.CertificatePinner
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor


object BaseClient {
    const val baseUrl = "https://mail.satprof.pro/"

    private val interceptor = HttpLoggingInterceptor()
    var okHttpClient: OkHttpClient? = OkHttpClient()
    val client = OkHttpClient.Builder().certificatePinner(CertificatePinner.DEFAULT).addInterceptor(
    interceptor).build()

    init {
        interceptor.level = HttpLoggingInterceptor.Level.BODY
    }
}