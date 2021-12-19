package com.length.icthack3.presentation.screens

import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.length.icthack3.R
import com.length.icthack3.domain.model.User
import com.length.icthack3.presentation.util.randomId
import com.length.icthack3.presentation.util.startActivityAndFinish
import com.length.icthack3.presentation.viewModels.LoginViewModel

class LoginActivity : AppCompatActivity() {

    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)

        val userToken = findViewById<TextInputEditText>(R.id.editLogin)
        val navigateToMainButton = findViewById<MaterialButton>(R.id.toMainButton)
        val navigateToRegistrationButton = findViewById<TextView>(R.id.toRegistrationFragment)

        navigateToRegistrationButton.setOnClickListener {

        }

        navigateToMainButton.setOnClickListener {
            val newUser = User(
                username = "user",
                token = randomId(),
                exchangeToken = randomId()
            )
            startActivityAndFinish(this, GameActivity::class.java)
        }
    }

}