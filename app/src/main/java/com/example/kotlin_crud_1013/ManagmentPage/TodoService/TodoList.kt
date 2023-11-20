package com.example.kotlin_crud_1013.ManagmentPage.TodoService

import MyRecyclerViewAdapter
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_crud_1013.ManagmentPage.TodoService.TodoData.TodoDatabase
import com.example.kotlin_crud_1013.ManagmentPage.TodoService.TodoData.TodoTable
import com.example.kotlin_crud_1013.databinding.TodoRecyclerViewBinding

class TodoList : AppCompatActivity() {
    private lateinit var db : TodoDatabase

    private val binding : TodoRecyclerViewBinding by lazy {
        TodoRecyclerViewBinding.inflate(layoutInflater)
    }

//    init{
//        val todolist : LiveData<List<TodoTable>> = db.getTodoDao().getData()
//
//        Log.d("SHOW", "${todolist}")
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        db = TodoDatabase.getInstance(this)

        val todolist : LiveData<List<TodoTable>> = db.getTodoDao().getData()

        val recyclerView:RecyclerView = binding.recyclerView
        val adapter = MyRecyclerViewAdapter(todolist)

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}
