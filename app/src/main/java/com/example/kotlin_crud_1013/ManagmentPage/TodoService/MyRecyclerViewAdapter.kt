import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_crud_1013.ManagmentPage.TodoService.TodoData.TodoTable
import com.example.kotlin_crud_1013.R
import com.example.kotlin_crud_1013.databinding.TodoHolderBinding
import kotlinx.android.synthetic.main.todo_holder.view.title

class MyRecyclerViewAdapter : RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder>() {

    val TAG: String = "로그"

    private var todoList = listOf<TodoTable>()
    class MyViewHolder(val binding: TodoHolderBinding) : RecyclerView.ViewHolder(binding.root)

    //어떤 xml으로 뷰 홀더를 생성할지 지정
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = TodoHolderBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyViewHolder(binding)
    }
    //뷰 홀더에 데이터 바인딩
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Log.d(TAG, "onBindViewHolder() called")
        val cur = todoList[position]
        holder.binding.title.text = cur.todo.toString()
    }
    // 뷰 홀더 개수 리턴
    override fun getItemCount(): Int {
        return this.todoList.size
    }

    fun setTodoList(todoTable: List<TodoTable>) {
        this.todoList = todoTable
        notifyDataSetChanged()
    }

}