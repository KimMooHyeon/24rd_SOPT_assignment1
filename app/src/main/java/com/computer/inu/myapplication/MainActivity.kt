package com.computer.inu.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.widget.RelativeLayout
import com.computer.inu.fragmentsoptandroidsemina2.ProductMainPagerAdapter
import com.computer.inu.fragmentsoptandroidsemina2.SharedPreferenceController
import kotlinx.android.synthetic.main.toolbar_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val temp: List<Drawable>
        temp = ArrayList()
        temp.add(ContextCompat.getDrawable(this,R.drawable.monnjaein)!!);
        temp.add(ContextCompat.getDrawable(this,R.drawable.hongjunpyo)!!);
        temp.add(ContextCompat.getDrawable(this,R.drawable.youseounmin)!!);



        configureMainTab()

        iv_toolbar_main_action.setOnClickListener {
            if(SharedPreferenceController.getToken(this).isNotEmpty()){
               SharedPreferenceController.clearToken(this)
                startActivity<LoginActivity>()
            }
        }

    }


    override fun onResume() {
        super.onResume()
        configureTitleBar()
    }
private fun configureTitleBar(){
    if(SharedPreferenceController.getToken(this).isNotEmpty()){
        iv_toolbar_main_action.isSelected=true
    }else{
        iv_toolbar_main_action.isSelected=false
    }
}
    private fun configureMainTab() {
        vp_main_product.adapter = ProductMainPagerAdapter(supportFragmentManager, 3)
        vp_main_product.offscreenPageLimit = 2
        tl_main_categoty.setupWithViewPager(vp_main_product)

        val navCategoryMainLayout: View =
            (this.getSystemService(android.content.Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater).inflate(
                R.layout.navaigation_category_main,
                null,
                false
            )
        tl_main_categoty.getTabAt(0)!!.customView=navCategoryMainLayout.findViewById(R.id.rl_nav_category_main_all) as RelativeLayout
        tl_main_categoty.getTabAt(1)!!.customView=navCategoryMainLayout.findViewById(R.id.rl_nav_category_main_new) as RelativeLayout
        tl_main_categoty.getTabAt(2)!!.customView=navCategoryMainLayout.findViewById(R.id.rl_nav_category_main_end) as RelativeLayout

      vp_main_slider.adapter= SliderMainPagerAdapter(supportFragmentManager,3)
        vp_main_slider.offscreenPageLimit=2
        tl_main_indicator.setupWithViewPager(vp_main_slider)


    }
}