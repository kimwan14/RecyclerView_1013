package com.example.kotlin_crud_1013

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.kotlin_crud_1013.ManagmentPage.managment_page
import com.example.kotlin_crud_1013.databinding.ActivityMainBinding
import com.example.kotlin_crud_1013.login.Sign
import com.example.kotlin_crud_1013.login.UserDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }



    private lateinit var db: UserDatabase
    private lateinit var email:String
    private lateinit var password: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val intent = Intent(this, Sign::class.java)
        val intent2 = Intent(this, managment_page::class.java)



        db = UserDatabase.getInstance(this)

        binding.btnLogin.setOnClickListener{
            email = binding.etEmail.text.toString()
            password = binding.etPassword.text.toString()

            if(email.isNotEmpty() && password.isNotEmpty()){
                CoroutineScope(Dispatchers.IO).launch {
                    if(db.getLoginDao().getEmailList().contains(email)||db.getLoginDao().getPwList().contains(password)){
                        startActivity(intent2)
                    }else{
                        withContext(Dispatchers.Main){
                            Toast.makeText(applicationContext, "오류.", Toast.LENGTH_SHORT).show()

                        }
                    }
                }
            }
        }

        binding.btnSign.setOnClickListener {
            startActivity(intent)
        }
    }

//    private fun setFrag(fragnum: Int) {
//        val ft = supportFragmentManager.beginTransaction()
//        when(fragnum){
//            0 -> {
//                ft.replace(R.id.fragment_main, SignFragment()).commit()
//            }
//        }
//    }
}