package com.example.kotlin_crud_1013.ManagmentPage.TodoService.TodoData

import android.app.Application
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [TodoTable::class], version = 1, exportSchema = false)
abstract class TodoDatabase : RoomDatabase() {
    abstract fun getTodoDao(): TodoDao

    companion object {
        @Volatile
        private var INSTANCE: TodoDatabase? = null

        private fun buildDatabase(context: Context): TodoDatabase =
            Room.databaseBuilder(
                context.applicationContext,
                TodoDatabase::class.java,
                "TODO"
            ).fallbackToDestructiveMigration().build()

        fun getInstance(context: Application): TodoDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }

    }
}