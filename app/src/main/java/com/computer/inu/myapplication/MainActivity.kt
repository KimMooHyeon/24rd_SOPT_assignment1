package com.computer.inu.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity
import android.graphics.drawable.Drawable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.RelativeLayout
import com.computer.inu.fragmentsoptandroidsemina2.ProductMainPagerAdapter
import com.computer.inu.fragmentsoptandroidsemina2.SharedPreferenceController
import com.computer.inu.myapplication.Network.ApplicationController
import com.computer.inu.myapplication.Network.Get.GetWebtoonMainImageResponse
import com.computer.inu.myapplication.Network.NetworkService
import com.computer.inu.myapplication.Network.Post.PostLoginResponse
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import kotlinx.android.synthetic.main.toolbar_main.*
import org.jetbrains.anko.ctx
import org.jetbrains.anko.toast
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    val networkService : NetworkService by lazy {
        ApplicationController.instance.networkService
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getMainImageResponse()


        iv_toolbar_main_action.setOnClickListener {
            if(SharedPreferenceController.getToken(this).isNotEmpty()){
               SharedPreferenceController.clearToken(this)
                startActivity<LoginActivity>()
            }
        }

    }
    fun getMainImageResponse(){
        var getWebtoonMainImageResponse: Call<GetWebtoonMainImageResponse> = networkService.getWebtoonMainImageResponse()
        getWebtoonMainImageResponse.enqueue(object : Callback<GetWebtoonMainImageResponse> {
            override fun onResponse(call: Call<GetWebtoonMainImageResponse>?, response: Response<GetWebtoonMainImageResponse>?) {
                Log.v("TAG", "보드 서버 통신 연결")
                if (response!!.isSuccessful) {
                    if(response.body()!!.status==200) {
                        configureMainTab(response.body()!!.data!!)
                    }

                }
            }
            override fun onFailure(call: Call<GetWebtoonMainImageResponse>?, t: Throwable?) {
                Log.v("TAG", "통신 실패 = " +t.toString())
            }
        })
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
    private fun configureMainTab( img : ArrayList<String>) {
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
      vp_main_slider.adapter= SliderMainPagerAdapter(supportFragmentManager,3,img)
        vp_main_slider.offscreenPageLimit=2
        tl_main_indicator.setupWithViewPager(vp_main_slider)
    }
}