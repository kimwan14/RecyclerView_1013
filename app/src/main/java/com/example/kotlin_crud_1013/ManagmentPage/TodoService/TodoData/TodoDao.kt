package com.example.kotlin_crud_1013.ManagmentPage.TodoService.TodoData

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import java.util.concurrent.Flow

@Dao
interface TodoDao {
    @Insert
    suspend fun insertData(input: TodoTable)

    @Update
    suspend fun updata(input: TodoTable)

    @Delete
    suspend fun delect(input: TodoTable)

    @Query("select * from TodoData  ORDER BY id ASC")
    fun getData() : LiveData<List<TodoTable>>
}