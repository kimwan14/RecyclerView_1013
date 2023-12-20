package com.example.kotlin_crud_1013.ManagmentPage.TodoService

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.kotlin_crud_1013.ManagmentPage.TodoService.TodoData.TodoDatabase
import com.example.kotlin_crud_1013.ManagmentPage.TodoService.TodoData.TodoTable
import com.example.kotlin_crud_1013.Repository.repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TodoViewModel(application: Application) : AndroidViewModel(application) {

    private val _repository: repository
    val getAll: LiveData<List<TodoTable>>

    init {
        val todoDao = TodoDatabase.getInstance(application)!!.getTodoDao()
        _repository = repository(todoDao)
        getAll = _repository.readAllData
    }
    suspend fun addTodo(Data: TodoTable) {
        viewModelScope.launch(Dispatchers.IO) {
            _repository.addData(Data)
        }
    }

    suspend fun delectTodo(Data: TodoTable){
        _repository.delect(Data)
    }

    suspend fun upDataTodo(Data: TodoTable){
        _repository.update(Data)
    }
    class Factory(val application: Application) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return TodoViewModel(application) as T
        }
    }


}


