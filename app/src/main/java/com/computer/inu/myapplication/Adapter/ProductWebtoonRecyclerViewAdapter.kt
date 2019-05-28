package com.computer.inu.myapplication.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import com.bumptech.glide.Glide
import com.computer.inu.myapplication.Data.ProductWebtoonData
import com.computer.inu.myapplication.InWebToonActivity
import com.computer.inu.myapplication.R
import org.jetbrains.anko.startActivity

class ProductWebtoonRecyclerViewAdapter(val ctx : Context, val dataList : ArrayList<ProductWebtoonData>, val idx : Int,val title:String): RecyclerView.Adapter<ProductWebtoonRecyclerViewAdapter.Holder>(){
    override fun onBindViewHolder(holder: Holder, position: Int) {
        Glide.with(ctx).load(dataList[position].img).into(holder.img)
        holder.date.text=dataList[position].date
        holder.title.text=dataList[position].title
        holder.hit_num.text=dataList[position].hitnum.toString()
    holder.rl_product_all.setOnClickListener {
      ctx.startActivity<InWebToonActivity>("idx" to idx,"title" to title)
    }
    }

    override fun getItemCount(): Int=dataList.size

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): Holder {
        val view: View = LayoutInflater.from(ctx).inflate(R.layout.rv_item_product_webtoon,p0,false)
        return Holder(view)
    }


    inner class Holder(ItemView : View) : RecyclerView.ViewHolder(ItemView){
        var img = itemView.findViewById(R.id.iv_product_item) as ImageView
        var title = itemView.findViewById(R.id.tv_webtoon_title) as TextView
        var hit_num = itemView.findViewById(R.id.tv_webtoon_hitsnumber) as TextView
        var date = itemView.findViewById(R.id.tv_webtoon_day) as TextView
        var rl_product_all = itemView.findViewById(R.id.rl_product_all) as RelativeLayout
    }


}