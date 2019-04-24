package com.computer.inu.myapplication

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_signup.*
import java.text.SimpleDateFormat
import java.util.*

class SignupActivity : AppCompatActivity() {

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
                finish()
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
}
