package com.example.kotlin_crud_1013.Repository

import com.example.kotlin_crud_1013.login.UserDao
import com.example.kotlin_crud_1013.login.UserTable

class user_repository(private val userDao: UserDao) {

    suspend fun addUser(userTable: UserTable){
        userDao.insertUser(userTable)
    }

    suspend fun getEmailList(userTable: UserTable){
        userDao.getEmailList()
    }
}