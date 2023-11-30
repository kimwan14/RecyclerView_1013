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
import com.example.kotlin_crud_1013.Repository.repository
import com.example.kotlin_crud_1013.databinding.TodoRecyclerViewBinding

class TodoList : AppCompatActivity() {
    private lateinit var db : TodoDatabase
    private lateinit var todoViewModel: TodoViewModel

    private val todoData: LiveData<List<TodoTable>> = todoViewModel.getAll

    private val binding : TodoRecyclerViewBinding by lazy {
        TodoRecyclerViewBinding.inflate(layoutInflater)
    }

    private lateinit var myRecyclerViewAdapter: MyRecyclerViewAdapter

    private val TAG:String = "로그"

    init {
        Log.d(TAG,"DataList &todoData")
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        myRecyclerViewAdapter = MyRecyclerViewAdapter()
    }
}
