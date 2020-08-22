package com.example.hello

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.Toast
import android.widget.Toast.*
import ke.co.hello.ApiClient
import ke.co.hello.ApiInterface
import ke.co.hello.CoursesActivity
import ke.co.hello.R
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.Call
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvRegister.setOnClickListener {
            val intent=Intent(baseContext,RegistrationActivity::class.java)
            startActivity(intent)
        }

     btnLogin.setOnClickListener{
         var userName=etUsername.text.toString()
         var password=etPassword.text.toString()
         Toast.makeText(baseContext,password,LENGTH_SHORT).show()
         val requestBody = MultipartBody.Builder()
             .setType(MultipartBody.FORM)
             .addFormDataPart("userName",userName)
             .addFormDataPart("password", password)
             .build()

         loginUser(requestBody)
     }
    }

    fun loginUser(requestBody: RequestBody){
        val apiClient = ApiClient.buildService(ApiInterface::class.java)
        val loginCall = apiClient.loginStudent(requestBody)

        loginCall.enqueue(object :Callback<LoginResponse!>! {
            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                if (response.isSuccessful){
                    Toast.makeText(baseContext, response.body()?.message, Toast.LENGTH_LONG).show()
                    var accessToken = response.body()?.accessToken
                    var sharedPreferences = PreferenceManager.getDefaultSharedPreferences(baseContext)
                    var editor = sharedPreferences.edit()
                    editor.putString("ACCESS_TOKEN_KEY", accessToken)
                    editor.apply()
                    val intent = Intent(baseContext, CoursesActivity::class.java)
                    startActivity(intent)
                    finish()
                }
                else{
                    Toast.makeText(baseContext, response.errorBody().toString(), Toast.LENGTH_LONG).show()
                }
            }
        })
    }
}





