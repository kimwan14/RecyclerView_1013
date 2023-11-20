import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_crud_1013.ManagmentPage.TodoService.TodoData.TodoTable
import com.example.kotlin_crud_1013.databinding.TodoHolderBinding

class MyRecyclerViewAdapter(todolist: LiveData<List<TodoTable>>) :
    RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder>() {

    private var _todoList: LiveData<List<TodoTable>> = todolist

    class MyViewHolder(binding: TodoHolderBinding) : RecyclerView.ViewHolder(binding.root) {
        val _title = binding.title
    }

    // 어떤 xml 으로 뷰 홀더를 생성할지 지정
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = TodoHolderBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return MyViewHolder(binding)
    }

    // 뷰 홀더에 데이터를 바인딩
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val itemList = _todoList.value
        if (itemList != null && position < itemList.size) {
            val item = itemList[position]
            holder._title.text = item.todo
        }
    }

    // 뷰 홀더의 개수 리턴
    override fun getItemCount(): Int {
        return _todoList.value?.size ?: 0
    }


}
