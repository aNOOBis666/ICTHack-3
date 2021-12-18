package com.length.icthack3.presentation

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent

import android.os.Bundle
import com.length.icthack3.presentation.screens.LoginActivity
import com.length.icthack3.presentation.screens.MainActivity
import com.length.icthack3.presentation.util.startActivityAndFinish


class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        navigateFromSplash()
    }

    private fun navigateFromSplash() {
        if (true) {
            startActivityAndFinish(this, LoginActivity::class.java)
        } else {
            startActivityAndFinish(this, MainActivity::class.java)
        }
    }
}