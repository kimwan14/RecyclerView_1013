package com.example.kotlin_crud_1013.login

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "UserEntity")
data class UserTable (
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    @ColumnInfo
    val email:String,
    @ColumnInfo
    val password:String
)