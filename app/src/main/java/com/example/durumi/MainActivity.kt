package com.example.durumi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebViewClient
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
        webView.loadUrl("https://www.naver.com") //링크 주소를 load
    }

    //back 버튼 로직
    override fun onBackPressed() {
        if(webView.canGoBack()){ //웹 상에서 뒤로 갈 페이지가 존재 한다면
            webView.goBack() //웹 사이트 뒤로 가기
        }
        else {
            super.onBackPressed()
        }
    }
}