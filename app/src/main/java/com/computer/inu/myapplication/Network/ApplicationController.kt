package com.computer.inu.myapplication.Network

import android.app.Application
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApplicationController : Application() {
    private val baseURL = "http://hyunjkluz.ml:2424" // 통신하고자 하는 API 서버의 기본주소
    lateinit var networkService: NetworkService
    companion object {
        lateinit var instance: ApplicationController
    }
    override fun onCreate() {
        super.onCreate()
        instance = this
        buildNetWork()
    }
    fun buildNetWork() {
        val retrofit: Retrofit = Retrofit.Builder() //Retrofit 객체 생성
            .baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        networkService = retrofit.create(NetworkService::class.java) // Retrofit 객체 활성화
    }
}