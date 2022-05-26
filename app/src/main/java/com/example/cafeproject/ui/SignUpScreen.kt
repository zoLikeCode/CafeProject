package com.example.cafeproject.ui

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.widget.Toast
import com.example.cafeproject.api.RequestApiService
import com.example.cafeproject.databinding.ActivitySignUpScreenBinding
import com.example.cafeproject.model.Auth
import com.example.cafeproject.model.Token
import com.example.cafeproject.model.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpScreen : AppCompatActivity() {
    lateinit var prefs: SharedPreferences
    lateinit var binding: ActivitySignUpScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        prefs = getSharedPreferences("global", Context.MODE_PRIVATE)
        init()
    }

    private fun init() = with(binding) {
        cancelButton.setOnClickListener {
            val intent = Intent(this@SignUpScreen, SignInScreen::class.java)
            startActivity(intent)
        }

        register.setOnClickListener {
            if (Patterns.EMAIL_ADDRESS.matcher(EmailText.text)
                    .matches() && PasswordText.text.isNotEmpty()
                && FullName.text.isNotEmpty()
                && PhoneText.text.isNotEmpty()
            ) {
                val serviceBuilder = RequestApiService.create()
                serviceBuilder.registration(
                    user = User(
                        EmailText.text.toString(),
                        PasswordText.text.toString(),
                        FullName.text.toString()
                    )
                ).enqueue(object : retrofit2.Callback<String> {
                    override fun onResponse(call: Call<String>, response: Response<String>) {
                        if (response.isSuccessful) {
                            login(
                                serviceBuilder,
                                EmailText.text.toString(),
                                PasswordText.text.toString()
                            )
                        }
                    }

                    override fun onFailure(call: Call<String>, t: Throwable) {
                        Log.d("Retrofit", t.message!!)
                    }
                })
            } else {
                Toast.makeText(
                    this@SignUpScreen,
                    "Uncorrected Email, Password or Full name",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

    }

    private fun login(serviceBuilder: RequestApiService, email: String, password: String) {
        serviceBuilder.login(
            auth = Auth(
                email,
                password
            )
        ).enqueue(object : Callback<Token> {
            override fun onFailure(call: Call<Token>, t: Throwable) {
                Toast.makeText(
                    this@SignUpScreen,
                    t.message,
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun onResponse(call: Call<Token>, response: Response<Token>) {
                if (response.isSuccessful) {
                    val msg = response.body()!!.token
                    Toast.makeText(
                        this@SignUpScreen,
                        msg,
                        Toast.LENGTH_SHORT
                    ).show()
                    prefs.edit().putString("token", msg).apply()
                    val intent = Intent(this@SignUpScreen, MainScreen::class.java)
                    startActivity(intent)
                }
            }
        })
    }
}