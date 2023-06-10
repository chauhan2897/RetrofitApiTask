import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitapitask.DataModelItem
import com.example.retrofitapitask.MainActivity2
import com.example.retrofitapitask.R
import com.example.retrofitapitask.UserEntity

class CustomAdapter(val mList: ArrayList<DataModelItem>,val context: Context) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_layout, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val userModel: DataModelItem = mList.get(position)
        val currentItem=mList[position]
        holder.apply {
            title.text=("Title :  "+currentItem.title)
        }
        holder.title.setOnClickListener(View.OnClickListener {
            val intent = Intent(context, MainActivity2::class.java)
            intent.putExtra("userid", userModel.userId)
            intent.putExtra("id", userModel.id)
            intent.putExtra("title", userModel.title)
            intent.putExtra("body", userModel.body)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            context.startActivity(intent)
        })
    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val title: TextView = itemView.findViewById(R.id.titletxt)

    }
}
