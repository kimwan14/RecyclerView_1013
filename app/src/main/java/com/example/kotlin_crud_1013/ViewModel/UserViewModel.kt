package com.example.kotlin_crud_1013.ViewModel

import android.app.Application
import android.service.autofill.UserData
import androidx.annotation.RestrictTo.Scope
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.kotlin_crud_1013.Repository.user_repository
import com.example.kotlin_crud_1013.login.UserDao
import com.example.kotlin_crud_1013.login.UserDatabase
import com.example.kotlin_crud_1013.login.UserTable

class UserViewModel(application: Application): AndroidViewModel(application) {
    private lateinit var userRepository:user_repository
    private lateinit var readAllUser: List<LiveData<UserTable>>

    init {
        val userDao = UserDatabase.getInstance(application).getLoginDao()
        userRepository = user_repository(userDao)
    }
    suspend fun addUser(userTable: UserTable){

    }
}