package com.example.cafeproject.ui

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.example.cafeproject.R
import com.example.cafeproject.api.RequestApiService
import com.example.cafeproject.databinding.ActivitySignInScreenBinding
import com.example.cafeproject.model.Auth
import com.example.cafeproject.model.Token
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignInScreen : AppCompatActivity() {
    lateinit var prefs: SharedPreferences
    lateinit var binding: ActivitySignInScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        prefs = getSharedPreferences("global", Context.MODE_PRIVATE)
        init()
    }

    private fun init() = with(binding) {
        login.setOnClickListener {
            if (EmailAddress.text.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(EmailAddress.text)
                    .matches() && TextPassword.text.isNotEmpty()
            ) {
                val serviceBuilder = RequestApiService.create()
                serviceBuilder.login(
                    auth = Auth(
                        EmailAddress.text.toString(),
                        TextPassword.text.toString()
                    )
                ).enqueue(object : Callback<Token> {
                    override fun onFailure(call: Call<Token>, t: Throwable) {
                        Toast.makeText(
                            this@SignInScreen,
                            t.message,
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    override fun onResponse(call: Call<Token>, response: Response<Token>) {
                        if (response.isSuccessful) {
                            val msg = response.body()!!.token
                            Toast.makeText(
                                this@SignInScreen,
                                msg,
                                Toast.LENGTH_SHORT
                            ).show()
                            prefs.edit().putString("token", msg).apply()
                            val intent = Intent(this@SignInScreen, MainScreen::class.java)
                            startActivity(intent)
                        }
                    }
                })
            } else {
                Toast.makeText(
                    this@SignInScreen,
                    "Uncorrected E-mail or Password",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}