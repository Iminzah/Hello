package com.example.hello.activities

import android.content.Intent
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.View
import android.widget.Toast
import android.widget.Toast.Callback
import androidx.appcompat.app.AppCompatActivity
import com.example.hello.api.ApiInterface
import com.example.hello.response.LoginResponse
import ke.co.hello.ApiClient
import com.example.hello.activities.CoursesActivity
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
            val intent=Intent(baseContext, RegistrationActivity::class.java)
            startActivity(intent)
        }

     btnLogin.setOnClickListener{
         var userName=etUsername.text.toString()
         var password=etPassword.text.toString()
         var error = false

         if (userName.isBlank() || userName.isEmpty()) {
             error = true
             etUsername.error = "Email is required"
         }

         if (password.isBlank() || password.isEmpty()) {
             error = true
             etPassword.error = "Password is required"
         }

         val requestBody = MultipartBody.Builder()
             .setType(MultipartBody.FORM)
             .addFormDataPart("email", userName)
             .addFormDataPart("password", password)
             .build()

         if (!error) {
             pbLogin.visibility = View.VISIBLE
             loginUser(requestBody)
         }
     }
    }

    fun loginUser(requestBody: RequestBody) {
        val apiClient = ApiClient.buildService(ApiInterface::class.java)
        val loginCall = apiClient.loginStudent(requestBody)

        loginCall.enqueue(object : Callback<LoginResponse> {
            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
                pbLogin.visibility = View.GONE
            }

            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                if (response.isSuccessful) {
                    val pbLogin = null
                    pbLogin.visibility = View.GONE
                    Toast.makeText(baseContext, response.body()?.message, Toast.LENGTH_LONG).show()

                    var accessToken = response.body()?.accessToken
                    val studentId = response.body().studentId
                    var sharedPreferences =
                        PreferenceManager.getDefaultSharedPreferences(baseContext)
                    var editor = sharedPreferences.edit()
                    editor.putString("ACCESS_TOKEN_KEY", accessToken)
                    editor.putString("STUDENT_ID_KEY", studentId)
                    editor.apply()
                    val intent = Intent(baseContext, CoursesActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    Toast.makeText(baseContext, response.errorBody().toString(), Toast.LENGTH_LONG)
                        .show()
                }
            }
        })
    }
}

private fun Any.enqueue(any: Any) {

}
