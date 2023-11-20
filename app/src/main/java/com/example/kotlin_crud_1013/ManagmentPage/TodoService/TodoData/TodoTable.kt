package com.example.kotlin_crud_1013.ManagmentPage.TodoService.TodoData

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "TodoData")
data class TodoTable(
    @PrimaryKey(autoGenerate = true)
    val id : Long = 0L,
    @ColumnInfo
    val todo: String
)
