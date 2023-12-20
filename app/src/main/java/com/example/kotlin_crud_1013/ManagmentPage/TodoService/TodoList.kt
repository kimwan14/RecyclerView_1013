package com.example.kotlin_crud_1013.ManagmentPage.TodoService

import MyRecyclerViewAdapter
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin_crud_1013.ViewModel.TodoViewModel
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

        todoViewModel = ViewModelProvider(this, TodoViewModel.Factory(application)).get(
            TodoViewModel::class.java)


        binding.recyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)

        val adapter = MyRecyclerViewAdapter()
        binding.recyclerView.adapter = adapter
        todoViewModel.getAll.observe(this, { todos ->
            adapter.setTodoList(todos)
        })


    }
}
