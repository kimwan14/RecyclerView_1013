import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_crud_1013.ManagmentPage.TodoService.MyViewHolder
import com.example.kotlin_crud_1013.ManagmentPage.TodoService.TodoData.TodoTable
import com.example.kotlin_crud_1013.R
import com.example.kotlin_crud_1013.databinding.TodoHolderBinding

class MyRecyclerViewAdapter: RecyclerView.Adapter<MyViewHolder>() {

    val TAG: String = "로그"

    private var todoList = listOf<TodoTable>()

    //뷰홀더가 설정 되었을때
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
     //연결할 레이아웃 설정
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.todo_holder,parent))
    }

    override fun getItemCount(): Int {
        // 목록의 아이템 수
        return this.todoList.size
    }

    //뷰와 뷰홀더가 묶였을 때
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Log.d(TAG,"onBindViewHolder() called")
        holder.bind(this.todoList[position])
    }

    fun todolist(todoTable: List<TodoTable>){
        this.todoList = todoTable
    }

}
