package com.example.kotlin_crud_1013.ManagmentPage.TodoService

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.kotlin_crud_1013.ManagmentPage.TodoService.TodoData.TodoDatabase
import com.example.kotlin_crud_1013.ManagmentPage.TodoService.TodoData.TodoTable
import com.example.kotlin_crud_1013.Repository.repository
import com.example.kotlin_crud_1013.databinding.InputdataBinding
import com.example.kotlin_crud_1013.login.UserDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Todo : AppCompatActivity() {
    private val binding: InputdataBinding by lazy {
        InputdataBinding.inflate(layoutInflater)
    }

    private lateinit var todoviewModel: TodoViewModel
    private lateinit var title: String
    val TAG: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        todoviewModel = ViewModelProvider(this).get(TodoViewModel::class.java)


        binding.addbutton.setOnClickListener {
            title = binding.edInput.text.toString()

            if (title.isNotEmpty()) {
                CoroutineScope(Dispatchers.IO).launch {
                    todoviewModel.addTodo(TodoTable(todo = title))
                    binding.edInput.text.clear()
                }
            } else {
                Toast.makeText(
                    applicationContext,
                    "내용을 입력해주세요",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}