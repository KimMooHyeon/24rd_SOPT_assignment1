package com.computer.inu.myapplication

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.startActivityForResult
import org.jetbrains.anko.toast
import java.text.SimpleDateFormat
import java.util.*

class LoginActivity : AppCompatActivity() {
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

    fun postLoginResponse( id: String, pw: String){
        startActivity<MainActivity>()
    }
}
