package com.computer.inu.myapplication.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.computer.inu.myapplication.Data.CommentData
import com.computer.inu.myapplication.R

class CommentRecyclerViewAdapter(val ctx : Context, val dataList : ArrayList<CommentData>): RecyclerView.Adapter<CommentRecyclerViewAdapter.Holder>(){
    override fun onBindViewHolder(holder: Holder, position: Int) {
        Glide.with(ctx).load(dataList[position].img).into(holder.img)
        holder.date.text=dataList[position].date
        holder.name.text=dataList[position].name
        holder.time.text=dataList[position].time
        holder.contents.text=dataList[position].contents

    }

    override fun getItemCount(): Int=dataList.size

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): Holder {
        val view: View = LayoutInflater.from(ctx).inflate(R.layout.rv_item_comment,p0,false)
        return Holder(view)
    }


    inner class Holder(ItemView : View) : RecyclerView.ViewHolder(ItemView){
        var img = itemView.findViewById(R.id.iv_comment_image) as ImageView
        var name = itemView.findViewById(R.id.tv_comment_name) as TextView
        var time = itemView.findViewById(R.id.tv_commnet_time) as TextView
        var date = itemView.findViewById(R.id.tv_commnent_date) as TextView
        var contents = itemView.findViewById(R.id.tv_comment_contents) as TextView
    }


}