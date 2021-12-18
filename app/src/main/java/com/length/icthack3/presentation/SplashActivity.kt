package com.length.icthack3.presentation

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent

import android.os.Bundle


class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startActivity(Intent(this@SplashActivity, MainActivity::class.java))
        finish()
    }
}