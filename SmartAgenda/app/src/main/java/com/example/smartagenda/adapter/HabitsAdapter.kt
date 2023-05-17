package com.example.smartagenda.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.smartagenda.R
import com.example.smartagenda.model.Habit

class HabitsAdapter(val listener: OnHabitsClickListener ): RecyclerView.Adapter<HabitsAdapter.MyViewHolder>() {

    interface OnHabitsClickListener{
        fun onItemDelete(id: String)
    }

    private var myList = mutableListOf<Habit>()

    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val textView: TextView = itemView.findViewById(R.id.habitTv)
        val btnDelete: ImageView = itemView.findViewById(R.id.btnDelete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.habit_row_layout,parent,false))
    }

    override fun getItemCount(): Int {
        return myList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.textView.text = myList[position].habit
        holder.btnDelete.setOnClickListener{
            listener.onItemDelete(myList[position].id)
        }
    }

    fun setData(newList: List<Habit>){
        myList.clear()
        myList.addAll(newList)
        notifyDataSetChanged()
    }
}