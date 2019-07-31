package luxoft.project.verificationcode.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.number_list_item.view.*
import luxoft.project.verificationcode.R
import luxoft.project.verificationcode.Room.Entities.PhoneNumber

class NumbersRecyclerAdapter:RecyclerView.Adapter<NumbersRecyclerAdapter.ViewHolder>() {

    var numbersList:List<PhoneNumber> = ArrayList<PhoneNumber> ()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NumbersRecyclerAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.number_list_item, parent, false)
        val viewHolder = ViewHolder(view)
        return viewHolder
    }

    override fun getItemCount(): Int {
        return numbersList.size
    }

    override fun onBindViewHolder(viewHolder: NumbersRecyclerAdapter.ViewHolder, position: Int) {
      viewHolder.text_view_numbers.text = numbersList.get(position).number
    }

    fun setNumbers(listNumbers:List<PhoneNumber>){
        numbersList = listNumbers
        notifyDataSetChanged()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val text_view_numbers = view.text_view_number
    }

}