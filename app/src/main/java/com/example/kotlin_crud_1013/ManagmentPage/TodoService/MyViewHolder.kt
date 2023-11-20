package com.example.kotlin_crud_1013.ManagmentPage.TodoService

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.todo_holder.view.title

class MyViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {

    val TAG:String = "log"

    private val inputTitle = itemView.title

    init {
        Log.d(TAG,"MyViewHolder - init() called")
    }


}