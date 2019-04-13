package com.computer.inu.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity
import android.graphics.drawable.Drawable
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val temp: List<Drawable>
        temp = ArrayList()
        temp.add(ContextCompat.getDrawable(this,R.drawable.monnjaein)!!);
        temp.add(ContextCompat.getDrawable(this,R.drawable.hongjunpyo)!!);
        temp.add(ContextCompat.getDrawable(this,R.drawable.youseounmin)!!);

       var a =  Adapter(temp,this);

       var pager = findViewById(R.id.photos_viewpager) as ViewPager
        pager.setAdapter(a);


      var tabLayout = findViewById(R.id.tab_layout) as TabLayout
        tabLayout.setupWithViewPager(pager, true);


    }
}