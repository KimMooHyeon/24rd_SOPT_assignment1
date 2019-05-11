package com.computer.inu.myapplication.Frament


import android.os.Bundle
import android.os.Handler
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.computer.inu.fragmentsoptandroidsemina2.SharedPreferenceController
import com.computer.inu.myapplication.Adapter.ProductOverViewRecyclerViewAdapter
import com.computer.inu.myapplication.Data.ProductOverviewData
import com.computer.inu.myapplication.MainActivity
import com.computer.inu.myapplication.Network.ApplicationController
import com.computer.inu.myapplication.Network.Get.GetWebtoonMainResponse
import com.computer.inu.myapplication.Network.NetworkService
import com.computer.inu.myapplication.Network.Post.PostLoginResponse

import com.computer.inu.myapplication.R
import kotlinx.android.synthetic.main.fragment_all_product_main.*
import org.jetbrains.anko.ctx
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.support.v4.ctx
import org.jetbrains.anko.support.v4.startActivity
import org.jetbrains.anko.support.v4.toast
import org.jetbrains.anko.toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class AllProductMainFragment : Fragment() {
    val networkService : NetworkService by lazy {
        ApplicationController.instance.networkService
    }
lateinit var productOverViewRecyclerViewAdapter: ProductOverViewRecyclerViewAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_all_product_main, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        var dataList: ArrayList<ProductOverviewData> = ArrayList()

        productOverViewRecyclerViewAdapter = ProductOverViewRecyclerViewAdapter(context!!,dataList)
        rv_product_overview_all.adapter=productOverViewRecyclerViewAdapter
        rv_product_overview_all.layoutManager=GridLayoutManager(context!!,3)
        getMainProductListResponse()
    }
private fun getMainProductListResponse(){
    val getMainProductListResponse :Call<GetWebtoonMainResponse> = networkService.getWebtoonMainResponse(
        "application/json",1)
    getMainProductListResponse.enqueue(object : Callback<GetWebtoonMainResponse> {
        override fun onResponse(call: Call<GetWebtoonMainResponse>?, response: Response<GetWebtoonMainResponse>?) {
            if (response!!.isSuccessful) {
                if(response.body()!!.status==200) {
                    var tmp = response.body()!!.data!!
                    productOverViewRecyclerViewAdapter.dataList=tmp
                    productOverViewRecyclerViewAdapter.notifyDataSetChanged()
                } else{

                }
            }

        }
        override fun onFailure(call: Call<GetWebtoonMainResponse>?, t: Throwable?) {
            Log.v("TAG", "통신 실패 = " +t.toString())
        }
    })

}
}
