package com.computer.inu.myapplication

import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.computer.inu.myapplication.Frament.SliderMainFragment

class SliderMainPagerAdapter(fm:FragmentManager?,val num_fragment: Int): FragmentStatePagerAdapter(fm){
    override fun getCount(): Int {
        return num_fragment
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItem(p0: Int): Fragment? {   //TabLayout , ViewPager가 보여주고자 하는 View의 번호
     var fragment :SliderMainFragment = SliderMainFragment() // 보여질 Fragment는 모두 같은 클래스를 상속
        var bundle : Bundle= Bundle(1) // 한 개 Bundle에 담길 데이터의 개수 지정
        when(p0){
            0->bundle.putInt("background_color",Color.RED)
            1->bundle.putInt("background_color",Color.YELLOW)
            2->bundle.putInt("background_color",Color.GREEN)
       }
        fragment.arguments=bundle
        return  fragment
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}