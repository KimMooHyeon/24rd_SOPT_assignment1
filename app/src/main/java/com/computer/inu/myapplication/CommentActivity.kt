package com.computer.inu.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.computer.inu.myapplication.Adapter.CommentRecyclerViewAdapter
import com.computer.inu.myapplication.Adapter.ProductWebtoonRecyclerViewAdapter
import com.computer.inu.myapplication.Data.CommentData
import kotlinx.android.synthetic.main.activity_comment.*
import kotlinx.android.synthetic.main.activity_product.*
import kotlinx.android.synthetic.main.toolbar_comment.*

class CommentActivity : AppCompatActivity() {
    lateinit var commentRecyclerViewAdapter: CommentRecyclerViewAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comment)
        btn_toolbar_commnet_back.setOnClickListener {
            finish()
        }

        var dataList: ArrayList<CommentData> = ArrayList()
        dataList.add(CommentData("http://sopt.org/wp/wp-content/uploads/2014/01/24_SOPT-LOGO_COLOR-1.png","솝러버","23.21.38","19.03.25","문어에 대한 내용이 아주 유익하네요. 추천드려요! 다들 꼭 보시길~^^"))
        dataList.add(CommentData("http://sopt.org/wp/wp-content/uploads/2014/01/24_SOPT-LOGO_COLOR-1.png","솝맘","23.25.38","19.03.25","타코야끼가 생각나는 웹툰이에요^^ 타코야끼먹으면서 읽는거 추천~!"))
        dataList.add(CommentData("http://sopt.org/wp/wp-content/uploads/2014/01/24_SOPT-LOGO_COLOR-1.png","조총무","23.21.38","19.03.25","심심할 때 할게 없다면 이 웹툰을 읽어보세요!!_맑고 끗한 조총무"))
        dataList.add(CommentData("http://sopt.org/wp/wp-content/uploads/2014/01/24_SOPT-LOGO_COLOR-1.png","김스윗","23.21.38","19.03.25","감동적인 이야깅비니다...아주 스윗한 웹툰이네요ㅠㅋㅋㅋㅋㅋ"))
        commentRecyclerViewAdapter = CommentRecyclerViewAdapter(this,dataList)
        rv_commnet.adapter=commentRecyclerViewAdapter
        rv_commnet.layoutManager= LinearLayoutManager(this)
    }
}
