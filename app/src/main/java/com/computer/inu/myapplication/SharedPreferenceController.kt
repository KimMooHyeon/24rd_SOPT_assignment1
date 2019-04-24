package com.computer.inu.fragmentsoptandroidsemina2

import android.content.Context
import android.content.SharedPreferences

object SharedPreferenceController {

    private val LOGIN = "LOGIN"

    //자동로그인 설정
    fun setID(context: Context, authorization: String) {
        val pref = context.getSharedPreferences(LOGIN, Context.MODE_PRIVATE)
        val editor = pref.edit()
        editor.putString("u_id", authorization)
        editor.commit()
    }
    //자동로그인
    fun getId(context: Context): String {
        val pref = context.getSharedPreferences(LOGIN, Context.MODE_PRIVATE)
        return pref.getString("u_id", "")
    }

    //자동로그인 토큰
    fun clearLogin(context: Context) {
        val pref = context.getSharedPreferences(LOGIN, Context.MODE_PRIVATE)
        val editor = pref.edit()
        editor.clear()
        editor.commit()
    }

}