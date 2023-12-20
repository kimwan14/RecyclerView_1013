package com.example.kotlin_crud_1013.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.kotlin_crud_1013.ManagmentPage.TodoService.TodoData.TodoDatabase
import com.example.kotlin_crud_1013.ManagmentPage.TodoService.TodoData.TodoTable
import com.example.kotlin_crud_1013.Repository.todo_repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TodoViewModel(application: Application) : AndroidViewModel(application) {

    private val _todo_repository: todo_repository
    val getAll: LiveData<List<TodoTable>>

    init {
        val todoDao = TodoDatabase.getInstance(application)!!.getTodoDao()
        _todo_repository = todo_repository(todoDao)
        getAll = _todo_repository.readAllData
    }
    suspend fun addTodo(Data: TodoTable) {
        viewModelScope.launch(Dispatchers.IO) {
            _todo_repository.addData(Data)
        }
    }

    suspend fun delectTodo(Data: TodoTable){
        _todo_repository.delect(Data)
    }

    suspend fun upDataTodo(Data: TodoTable){
        _todo_repository.update(Data)
    }
    class Factory(val application: Application) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return TodoViewModel(application) as T
        }
    }


}


