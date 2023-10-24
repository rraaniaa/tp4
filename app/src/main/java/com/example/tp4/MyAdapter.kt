import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

import com.example.tp4.R

class MyAdapter(private val myDataSet: ArrayList<String>, private val listener: OnItemClickListener) :
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    inner class ViewHolder(val itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        val vText: TextView = itemView.findViewById(R.id.word)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val vh = LayoutInflater.from(parent.context).inflate(R.layout.ligne, parent, false)
        return ViewHolder(vh)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val current = myDataSet[position]
        holder.vText.text = current
    }

    override fun getItemCount(): Int {
        return myDataSet.size
    }
}
