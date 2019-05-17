package com.computer.inu.myapplication

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_write_comment.*
import kotlinx.android.synthetic.main.toolbar_write_comment.*
import org.jetbrains.anko.startActivityForResult

class WriteCommentActivity : AppCompatActivity() {
    lateinit var selecterPicUri : Uri
     val REQUEST_CODE_SELECT_IMAGE: Int= 1004
    var product_id= -1
    var episode_id = -1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_write_comment)

    configureToolbar()

    }

    private fun configureToolbar(){
        product_id=intent.getIntExtra("idx",-1)
        episode_id=intent.getIntExtra("episode_id",-1)
        if(product_id==-1||episode_id==-1) finish()
        tv_toolbar_back.setOnClickListener {
            finish() //뒤로가기
        }
        tv_toolbar_confirm.setOnClickListener {

            //확인버튼
        }
        iv_write_comment_camera.setOnClickListener {
            //카메라열기
            val intent = Intent(Intent.ACTION_PICK)
           intent.type=android.provider.MediaStore.Images.Media.CONTENT_TYPE
            intent.data=android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI
            startActivityForResult(intent,REQUEST_CODE_SELECT_IMAGE)

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE_SELECT_IMAGE){
            if(requestCode==Activity.RESULT_OK){
                data?.let {
                    selecterPicUri=it.data
                    Glide.with(this).load(selecterPicUri).thumbnail(0.1f).into(iv_write_write_roll)
                }
            }
        }
    }
}
