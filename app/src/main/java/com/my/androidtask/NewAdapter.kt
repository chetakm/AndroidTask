package com.my.androidtask

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NewAdapter(val context:Context,val data:List<Info>): RecyclerView.Adapter<NewAdapter.DataViewHolder>(){

  class  DataViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
      var textView1=itemView.findViewById<TextView>(R.id.textView1)
      var textView2=itemView.findViewById<TextView>(R.id.textView2)

  }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val view=LayoutInflater.from(context).inflate(R.layout.item,parent,false)
        return DataViewHolder(view)

    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
          val da=data[position]
          holder.textView1.text=da.title
          holder.textView2.text=da.body



    }

    override fun getItemCount(): Int {
       return  data.size

    }
}