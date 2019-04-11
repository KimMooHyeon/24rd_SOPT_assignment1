package com.computer.inu.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.startActivity

class LoginActivity : AppCompatActivity() {

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


            startActivity<SignupActivity>()
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
    fun postLoginResponse( id: String, pw: String){
        finish()
    }
}
