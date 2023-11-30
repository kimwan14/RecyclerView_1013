package com.example.kotlin_crud_1013.ManagmentPage.TodoService

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_crud_1013.ManagmentPage.TodoService.TodoData.TodoTable
import kotlinx.android.synthetic.main.todo_holder.view.title

class MyViewHolder(todoView: View): RecyclerView.ViewHolder(todoView) {

    val TAG:String = "log"

    private val titleView = todoView.title

    init {
        Log.d(TAG,"ViewHolder - init() called")
    }

    //데이터와 뷰를 묶어주는 함수
    fun bind(todoTable: TodoTable){
        Log.d(TAG,"ViewHolder - bind() called")

        titleView.text = todoTable.todo
    }
}