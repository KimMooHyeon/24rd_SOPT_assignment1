package com.computer.inu.myapplication.Network.Get

import com.computer.inu.myapplication.Data.ProductOverviewData

data class GetWebtoonMainResponse(
    val status : Int,
    val success : Boolean,
    val message : String,
    val data : ArrayList<ProductOverviewData>?
)