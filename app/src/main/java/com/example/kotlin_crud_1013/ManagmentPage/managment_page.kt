package com.example.kotlin_crud_1013.ManagmentPage

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin_crud_1013.ManagmentPage.TodoService.Todo
import com.example.kotlin_crud_1013.ManagmentPage.TodoService.TodoList
import com.example.kotlin_crud_1013.databinding.ManagementPageBinding

class managment_page : AppCompatActivity() {
    private val binding: ManagementPageBinding by lazy {
        ManagementPageBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        // 여기에 액티비티에서 필요한 동작 및 UI 업데이트 코드를 추가하세요.
        val todo = Intent(this, Todo::class.java)
        val todolist = Intent(this, TodoList::class.java)
        binding.todo.setOnClickListener {
            startActivity(todo)
        }

        binding.todolist.setOnClickListener {
            startActivity(todolist)

        }
    }

}