package com.computer.inu.myapplication

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.computer.inu.fragmentsoptandroidsemina2.SharedPreferenceController
import com.computer.inu.myapplication.Network.ApplicationController
import com.computer.inu.myapplication.Network.NetworkService
import com.computer.inu.myapplication.Network.Post.PostLoginResponse
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.ctx
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.startActivityForResult
import org.jetbrains.anko.toast
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*

class LoginActivity : AppCompatActivity() {
    val networkService : NetworkService by lazy {
        ApplicationController.instance.networkService
    }
 val REQUEST_CODE_LOGIN_ACTIVITY = 1000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        btnLoginSubmit.setOnClickListener {
            val id = edtLoginID.text.toString()
            val pw = edtLoginPW.text.toString()

            if(id =="") edtLoginID.requestFocus()
            else if (pw=="") edtLoginPW.requestFocus()
           else postLoginResponse(id,pw)
        }
        txtLoginSignup.setOnClickListener {

 val simpleDateFormat = SimpleDateFormat("dd/M/yyyy hh:mmss")
            val s_time = simpleDateFormat.format(Date())

            startActivityForResult<SignupActivity>(REQUEST_CODE_LOGIN_ACTIVITY,"start_time" to s_time)
        }
        edtLoginID.setOnFocusChangeListener { v, hasFocus ->
            if(hasFocus) v.setBackgroundResource(R.drawable.yellow)
            else v.setBackgroundResource(R.drawable.gray)
        }
        edtLoginPW.setOnFocusChangeListener { v, hasFocus ->
            if(hasFocus) v.setBackgroundResource(R.drawable.yellow)
            else v.setBackgroundResource(R.drawable.gray)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==REQUEST_CODE_LOGIN_ACTIVITY){
            if(resultCode==Activity.RESULT_OK) {
                val e_time = data!!.getStringExtra("end_time")
                toast("End time: ${e_time}")
            }
        }
    }

    fun postLoginResponse(id :String, pw : String){
        var jsonObject = JSONObject()
        jsonObject.put("id", id)
        jsonObject.put("password", pw)

//Gson 라이브러리의 Json Parser을 통해 객체를 Json으로!
        val gsonObject = JsonParser().parse(jsonObject.toString()) as JsonObject
        var PostLoginResponse: Call<PostLoginResponse> = networkService.postLoginResponse("application/json",gsonObject)
        PostLoginResponse.enqueue(object : Callback<PostLoginResponse> {
            override fun onResponse(call: Call<PostLoginResponse>?, response: Response<PostLoginResponse>?) {
                Log.v("TAG", "보드 서버 통신 연결")
                if (response!!.isSuccessful) {
                    if(response.body()!!.status==201) {
                        SharedPreferenceController.setToken(ctx, response.body()!!.data!!)
                   startActivity<MainActivity>()
                    }
                    else {
                        toast("아이디 또는 비밀번호가 틀렸습니다.")
                    }
                }
                else{
                    Log.v("TAG", "마이페이지 서버 값 전달 실패")
                }
            }
            override fun onFailure(call: Call<PostLoginResponse>?, t: Throwable?) {
                Log.v("TAG", "통신 실패 = " +t.toString())
            }
        })
    }

}
