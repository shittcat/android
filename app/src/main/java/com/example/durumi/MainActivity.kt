package com.example.durumi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebViewClient
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        webView.settings.javaScriptEnabled = true //js 허용

        //웹뷰에서 새 창이 뜨지 않도록 방지
        webView.webViewClient = WebViewClient()
        webView.webChromeClient = WebChromeClient()

        //네이버 임시 링크
        webView.loadUrl("http://www.naver.com") //링크 주소를 load
    }


    //back 버튼 로직
    var time3:Long = 0
    override fun onBackPressed() {

        if(webView.canGoBack()){ //웹 상에서 뒤로 갈 페이지가 존재 한다면
            webView.goBack() //웹 사이트 뒤로 가기
        }
        else {
            val time1 = System.currentTimeMillis()
            val time2 = time1 - time3 //back버튼을 누른 간격
            if (time2 in 0..2000){//2초 이내에 back버튼을 눌렀다면
                finish()
                return
            }
            else {
                time3 = time1
                Toast.makeText(applicationContext, "한 번 더 누르면 종료합니다.", Toast.LENGTH_SHORT).show()
            }
            //super.onBackPressed()
        }
    }
}