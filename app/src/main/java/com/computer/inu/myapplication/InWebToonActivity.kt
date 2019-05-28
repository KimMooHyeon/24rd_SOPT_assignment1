package com.computer.inu.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.toolbar_product.*
import org.jetbrains.anko.startActivity

class InWebToonActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_in_web_toon)
        iv_toolbar_heart.setOnClickListener {
          startActivity<CommentActivity>("idx" to intent.getIntExtra("idx",-1))
        }
        btn_toolbar_product_back.setOnClickListener {
            finish()
        }
        txt_toolbar_product_title.setText(intent.getStringExtra("title"))
    }
}
