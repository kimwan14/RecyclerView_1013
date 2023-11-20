package com.example.kotlin_crud_1013.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin_crud_1013.MainActivity
import com.example.kotlin_crud_1013.ManagmentPage.managment_page
import com.example.kotlin_crud_1013.databinding.SignBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class Sign : AppCompatActivity() {
    private val binding: SignBinding by lazy {
        SignBinding.inflate(layoutInflater)
    }
    lateinit var email: String
    lateinit var password: String
    val db = UserDatabase.getInstance(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val backintent = Intent(this, MainActivity::class.java)
        val Mainintent = Intent(this, managment_page::class.java)


        binding.fr1BtnSign.setOnClickListener {
            email = binding.fr1EtEmail.text.toString()
            password = binding.fr1EtPassword.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                CoroutineScope(Dispatchers.IO).launch {
                    if (db.getLoginDao().getEmailList().contains(email)) {
                        if (db.getLoginDao().getPasswordByEmail(email) == password) {
                            withContext(Dispatchers.Main) {
                                Toast.makeText(
                                    applicationContext,
                                    "이미 가입된 계정입니다. 로그인을 진행합니다.",
                                    Toast.LENGTH_SHORT
                                ).show()

                            }
                        } else {
                            withContext(Dispatchers.Main) {
                                Toast.makeText(
                                    applicationContext,
                                    "비밀번호를 확인하세요",
                                    Toast.LENGTH_SHORT
                                ).show()

                            }
                        }
                    } else {

                        db.getLoginDao().insertUser(UserTable(email = email, password = password))
                        withContext(Dispatchers.Main) {
                            Toast.makeText(
                                applicationContext,
                                "환영합니다. 회원가입이 완료되었습니다.",
                                Toast.LENGTH_SHORT
                            ).show()
                            startActivity(Mainintent)

                        }
                    }
                }
            }
        }

        binding.fr1BtnBack.setOnClickListener {
            startActivity(backintent)
        }
    }
}


