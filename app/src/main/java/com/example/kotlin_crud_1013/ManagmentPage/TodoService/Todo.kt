package com.example.kotlin_crud_1013.ManagmentPage.TodoService

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin_crud_1013.ManagmentPage.TodoService.TodoData.TodoDatabase
import com.example.kotlin_crud_1013.ManagmentPage.TodoService.TodoData.TodoTable
import com.example.kotlin_crud_1013.databinding.InputdataBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Todo : AppCompatActivity() {
    private val binding : InputdataBinding by lazy {
        InputdataBinding.inflate(layoutInflater)
    }

    private lateinit var db: TodoDatabase
    private lateinit var title: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        db = TodoDatabase.getInstance(this)

        binding.addbutton.setOnClickListener {
            title = binding.edInput.text.toString()



            if(title.isNotEmpty()){
                CoroutineScope(Dispatchers.IO).launch {
                    db.getTodoDao().insertData(TodoTable(todo = title))

                }
            }else {
                    Toast.makeText(
                        applicationContext,
                        "내용을 입력해주세요",
                        Toast.LENGTH_SHORT
                    ).show()
            }
        }
    }
}