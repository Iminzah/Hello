package com.example.hello

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_registration.*

class RegistrationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        btnSignUp.setOnClickListener {
            var firstname = etFirstName.text.toString()
            var lastname=etFirstName.text.toString()
            var email = etEmail.text.toString()
            var phoneNumber = etPhone.text.toString()
            var password = etPassword.text.toString()
            var confirm = etConfirmPassword.text.toString()
            Toast.makeText(baseContext, password, Toast.LENGTH_LONG).show()
            Toast.makeText(baseContext, confirm, Toast.LENGTH_LONG).show()
            Toast.makeText(baseContext,email,Toast.LENGTH_LONG).show()
        }
    }
}