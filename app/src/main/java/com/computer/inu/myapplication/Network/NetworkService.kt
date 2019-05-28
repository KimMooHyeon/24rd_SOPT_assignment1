package com.computer.inu.myapplication.Network

import android.app.Activity
import android.app.Application
import com.computer.inu.myapplication.Network.Get.GetWebtoonMainImageResponse
import com.computer.inu.myapplication.Network.Get.GetWebtoonMainResponse
import com.computer.inu.myapplication.Network.Post.PostCommentResponse
import com.computer.inu.myapplication.Network.Post.PostLoginResponse
import com.computer.inu.myapplication.Network.Post.PostSignUpResponse
import com.google.gson.JsonObject
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface NetworkService {

    @POST("/api/auth/signup")
    fun postSignUpResponse(
        @Header("Content-Type") content_type: String,
        @Body() body: JsonObject
    ): Call<PostSignUpResponse>

    @POST("/api/auth/signin")
    fun postLoginResponse(
        @Header("Content-Type") content_type: String,
        @Body() body: JsonObject
    ): Call<PostLoginResponse>

    @GET("/api/webtoons/main/{flag}")
    fun getWebtoonMainResponse(
        @Header("Content-Type") content_type: String,
        @Path("flag") flag : Int
    ): Call<GetWebtoonMainResponse>
    
    @GET("/api/webtoons/main/img")
    fun getWebtoonMainImageResponse(
    ): Call<GetWebtoonMainImageResponse>
    @Multipart
    @POST("/api/webtoons/episodes/cmts")
    fun postCommentResponse(
        @Header("token") token: String,
        @Header("Content-Type") content_type: String,
        @Part("epldx") epldx : Int ,
        @Part("content") content : RequestBody,
        @Part cmtImg: MultipartBody.Part
    ): Call<PostCommentResponse>
}
