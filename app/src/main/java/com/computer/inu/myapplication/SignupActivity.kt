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
import com.computer.inu.myapplication.Network.Post.PostSignUpResponse
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_signup.*
import org.jetbrains.anko.ctx
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*

class SignupActivity : AppCompatActivity() {
    val networkService : NetworkService by lazy {
        ApplicationController.instance.networkService
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        btnSignUpSubmit.setOnClickListener {
            val id = edtsignupID.text.toString()
            val pw = edtsignupPW.text.toString()
            val name =et_siguup_nmae.text.toString()
            if(id =="") edtsignupID.requestFocus()
            else if (pw=="") edtsignupPW.requestFocus()
            else if (name=="") et_siguup_nmae.requestFocus()
            else {
                val simpleDateformat = SimpleDateFormat("dd/M/yyy hh:mm:ss")
                val e_time = simpleDateformat.format(Date())
                val intent : Intent= Intent()
                intent.putExtra("end_time",e_time)
                setResult(Activity.RESULT_OK,intent)
                postSignupResponse(id,name,pw)
            }
        }
        edtsignupID.setOnFocusChangeListener { v, hasFocus ->
            if(hasFocus) v.setBackgroundResource(R.drawable.yellow)
            else v.setBackgroundResource(R.drawable.gray)
        }
        edtsignupPW.setOnFocusChangeListener { v, hasFocus ->
            if(hasFocus) v.setBackgroundResource(R.drawable.yellow)
            else v.setBackgroundResource(R.drawable.gray)
        }
        et_siguup_nmae.setOnFocusChangeListener { v, hasFocus ->
            if(hasFocus) v.setBackgroundResource(R.drawable.yellow)
            else v.setBackgroundResource(R.drawable.gray)
        }
    }

    fun postSignupResponse(id :String,name:String, pw : String){
        var jsonObject = JSONObject()
        jsonObject.put("id", id)
        jsonObject.put("name",name)
        jsonObject.put("password", pw)

//Gson 라이브러리의 Json Parser을 통해 객체를 Json으로!
        val gsonObject = JsonParser().parse(jsonObject.toString()) as JsonObject
        var PostsignupResponse: Call<PostSignUpResponse> = networkService.postSignUpResponse("application/json",gsonObject)
        PostsignupResponse.enqueue(object : Callback<PostSignUpResponse> {
            override fun onResponse(call: Call<PostSignUpResponse>?, response: Response<PostSignUpResponse>?) {
                Log.v("TAG", "보드 서버 통신 연결")
                if (response!!.isSuccessful) {
                    if(response.body()!!.status==201) {
                        finish()
                       toast("회원가입 성공")
                    }
                    else {
                        finish()
                        toast("회원가입 실패")
                    }
                }
                else{

                }
            }
            override fun onFailure(call: Call<PostSignUpResponse>?, t: Throwable?) {
                Log.v("TAG", "통신 실패 = " +t.toString())
            }
        })
    }
}
