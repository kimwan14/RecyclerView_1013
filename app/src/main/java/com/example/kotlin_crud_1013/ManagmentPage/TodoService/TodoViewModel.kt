package com.example.kotlin_crud_1013.ManagmentPage.TodoService

import android.app.Application
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.room.RoomDatabase
import com.example.kotlin_crud_1013.ManagmentPage.TodoService.TodoData.TodoDao
import com.example.kotlin_crud_1013.ManagmentPage.TodoService.TodoData.TodoDatabase
import com.example.kotlin_crud_1013.ManagmentPage.TodoService.TodoData.TodoTable
import com.example.kotlin_crud_1013.Repository.repository

class TodoViewModel(application: Application) : AndroidViewModel(application) {

    private val _repository: repository = repository(TodoDatabase.getInstance(application))

    var getAll: LiveData<List<TodoTable>> = _repository.readAllData
    suspend fun addTodo(Data: TodoTable) {
        _repository.addData(Data)
    }

    suspend fun delectTodo(Data: TodoTable){
        _repository.delect(Data)
    }

    suspend fun upDataTodo(Data: TodoTable){
        _repository.update(Data)
    }

}