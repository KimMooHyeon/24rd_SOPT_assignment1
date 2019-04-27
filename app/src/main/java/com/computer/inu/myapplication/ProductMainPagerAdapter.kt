package com.computer.inu.fragmentsoptandroidsemina2

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.computer.inu.myapplication.Frament.AllProductMainFragment
import com.computer.inu.myapplication.Frament.EndProductMainFragment
import com.computer.inu.myapplication.Frament.NewProductMainFragment

class ProductMainPagerAdapter(fm : FragmentManager, private val num_frament: Int):FragmentStatePagerAdapter(fm){
/*
companion object {
    private var allProductMainFragment: AllProductMainFragment? = null
    private var newProductMainFragment: NewProductMainFragment? = null
    private var endProductMainFragment: EndProductMainFragment? =null

    @Synchronized
    fun getAllProductMainFragment(): AllProductMainFragment{
        if (allProductMainFragment==null) allProductMainFragment= AllProductMainFragment()
        return allProductMainFragment!!
    }
    @Synchronized
    fun getEndProductMainFragment(): EndProductMainFragment{
        if (endProductMainFragment==null) endProductMainFragment= EndProductMainFragment()
        return endProductMainFragment!!
    }

    @Synchronized
    fun getnewProductMainFragment(): NewProductMainFragment{
        if (newProductMainFragment==null) newProductMainFragment= NewProductMainFragment()
        return newProductMainFragment!!
    }
}
*/



    override fun getItem(p0 : Int): Fragment? {
        return when(p0){
            0->AllProductMainFragment()
            1->NewProductMainFragment()
            2-> EndProductMainFragment()
            else->null

        }
    }

    override fun getCount(): Int{
        return num_frament
    }
}