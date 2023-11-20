package com.example.kotlin_crud_1013.login

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {
    @Insert
    fun insertUser(user: UserTable)

    @Query("delete from UserEntity where email = :email and password = :password")
    fun deleteUser(email:String,password:String)

    @Query("select email from UserEntity")
    fun getEmailList(): List<String>

    @Query("select password from UserEntity")
    fun getPwList(): List<String>

    @Query("select password from UserEntity where email = :email")
    fun getPasswordByEmail(email:String) : String

}