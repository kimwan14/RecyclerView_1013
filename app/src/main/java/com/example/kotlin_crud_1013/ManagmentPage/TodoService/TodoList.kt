package com.example.kotlin_crud_1013.ManagmentPage.TodoService

import MyRecyclerViewAdapter
import android.icu.lang.UCharacter.VerticalOrientation
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_crud_1013.ManagmentPage.TodoService.TodoData.TodoDatabase
import com.example.kotlin_crud_1013.ManagmentPage.TodoService.TodoData.TodoTable
import com.example.kotlin_crud_1013.R
import com.example.kotlin_crud_1013.Repository.repository
import com.example.kotlin_crud_1013.databinding.TodoRecyclerViewBinding

class TodoList : AppCompatActivity() {
    private lateinit var todoViewModel: TodoViewModel
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
        //binding = DataBindingUtil.setContentView(this, R.layout.todo_recycler_view)

        todoViewModel = ViewModelProvider(this,TodoViewModel.Factory(application)).get(TodoViewModel::class.java)


        binding.recyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)

        val adapter = MyRecyclerViewAdapter()
        binding.recyclerView.adapter = adapter
        todoViewModel.getAll.observe(this, { todos ->
            adapter.setTodoList(todos)
        })


    }
}
