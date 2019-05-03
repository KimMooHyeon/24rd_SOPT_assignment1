package com.computer.inu.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import com.computer.inu.myapplication.Adapter.ProductOverViewRecyclerViewAdapter
import com.computer.inu.myapplication.Adapter.ProductWebtoonRecyclerViewAdapter
import com.computer.inu.myapplication.Data.ProductWebtoonData
import kotlinx.android.synthetic.main.activity_product.*
import kotlinx.android.synthetic.main.toolbar_product.*

class ProductActivity : AppCompatActivity() {
    lateinit var productWebtoonRecyclerViewAdapter: ProductWebtoonRecyclerViewAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)
        btn_toolbar_product_back.setOnClickListener {
            finish()
        }
        var dataList: ArrayList<ProductWebtoonData> = ArrayList()
        dataList.add(
            ProductWebtoonData(
            "http://sopt.org/wp/wp-content/uploads/2014/01/24_SOPT-LOGO_COLOR-1.png",
            "1화. 문어지지 말자!","13만회","19.03.25")
        )
        dataList.add(ProductWebtoonData(
            "http://sopt.org/wp/wp-content/uploads/2014/01/24_SOPT-LOGO_COLOR-1.png",
            "2화. 문어지지 말자 우리!","13만회","19.03.26"))
        dataList.add(ProductWebtoonData(
            "http://sopt.org/wp/wp-content/uploads/2014/01/24_SOPT-LOGO_COLOR-1.png",
            "3화. 타코야끼를 먹다,","13만회","19.03.27"))
        dataList.add(ProductWebtoonData(
            "http://sopt.org/wp/wp-content/uploads/2014/01/24_SOPT-LOGO_COLOR-1.png",
            "4화. 문어숙회를 먹다.","13만회","19.03.28"))
        dataList.add(ProductWebtoonData(
            "http://sopt.org/wp/wp-content/uploads/2014/01/24_SOPT-LOGO_COLOR-1.png",
            "5화. 문어빵을 먹다.","13만회","19.03.29"))
        dataList.add(ProductWebtoonData(
            "http://sopt.org/wp/wp-content/uploads/2014/01/24_SOPT-LOGO_COLOR-1.png",
            "6화. 배부른 문어","13만회","19.03.30"))
        productWebtoonRecyclerViewAdapter = ProductWebtoonRecyclerViewAdapter(this,dataList)
        rv_product.adapter=productWebtoonRecyclerViewAdapter
        rv_product.layoutManager= LinearLayoutManager(this)
    }

}
