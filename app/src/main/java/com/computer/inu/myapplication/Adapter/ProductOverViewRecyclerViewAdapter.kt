package com.computer.inu.myapplication.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.computer.inu.myapplication.Data.ProductOverviewData
import com.computer.inu.myapplication.R

class ProductOverViewRecyclerViewAdapter(val ctx : Context,val dataList : ArrayList<ProductOverviewData>): RecyclerView.Adapter<ProductOverViewRecyclerViewAdapter.Holder>(){
    override fun onBindViewHolder(holder: Holder, position: Int) {
        Glide.with(ctx).load(dataList[position].img_url).into(holder.img_thumbnail)
        holder.author.text=dataList[position].author
        holder.title.text=dataList[position].title
        holder.num_like.text=dataList[position].num_like.toString()
    }

    override fun getItemCount(): Int=dataList.size

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): Holder {
        val view: View= LayoutInflater.from(ctx).inflate(R.layout.rv_item_product_overview,p0,false)
        return Holder(view)
    }


    inner class Holder(ItemView : View) : RecyclerView.ViewHolder(ItemView){
        var img_thumbnail = itemView.findViewById(R.id.img_rv_item_product_overview_thumbnail) as ImageView
        var title = itemView.findViewById(R.id.txt_rv_item_product_overview_title) as TextView
        var num_like = itemView.findViewById(R.id.txt_rv_item_product_overview_numlike) as TextView
        var author = itemView.findViewById(R.id.txt_rv_item_product_overview_author) as TextView
    }


}