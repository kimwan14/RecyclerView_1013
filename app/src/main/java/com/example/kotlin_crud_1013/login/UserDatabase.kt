package com.example.kotlin_crud_1013.login

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [UserTable::class], version = 1, exportSchema = false)
abstract class UserDatabase : RoomDatabase() {
    abstract fun getLoginDao(): UserDao

    companion object{
        @Volatile
        private var INSTANCE: UserDatabase? = null

        private fun buildDatabase(context:Context): UserDatabase =
            Room.databaseBuilder(
                context.applicationContext,
                UserDatabase::class.java,
                "UserInfo"
            ).build()

        fun getInstance(context: Context): UserDatabase =
            INSTANCE ?: synchronized(this){
                INSTANCE ?: buildDatabase(context).also{ INSTANCE = it}
            }
    }
}