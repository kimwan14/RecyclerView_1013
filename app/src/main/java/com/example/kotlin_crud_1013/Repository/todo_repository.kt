package com.example.kotlin_crud_1013.Repository

import androidx.lifecycle.LiveData
import com.example.kotlin_crud_1013.ManagmentPage.TodoService.TodoData.TodoDao
import com.example.kotlin_crud_1013.ManagmentPage.TodoService.TodoData.TodoTable

class todo_repository(private val todoDao: TodoDao) {

    val readAllData: LiveData<List<TodoTable>> = todoDao.getAll()

//    companion object {
//        private var instance: repository? = null
//        fun getInstance(database: TodoDatabase): repository {
//            return instance
//                ?: synchronized(this) {
//                    val _instance = repository(database)
//                    instance = _instance
//                    _instance
//                }
//        }
//    }

    suspend fun addData(todo: TodoTable) {
        todoDao.insertData(todo)
    }

    suspend fun delect(todo: TodoTable) {
        todoDao.delect(todo)
    }

    suspend fun update(todo: TodoTable) {
        todoDao.updata(todo)
    }

}