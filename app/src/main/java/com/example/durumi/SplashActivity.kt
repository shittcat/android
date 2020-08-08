package com.example.durumi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

//앱 기동 스플래시 화면
class SplashActivity : AppCompatActivity() {
    
    val SPLASH_VIEW_TIME:Long = 2000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //splash view time 이후 main activity 실행 및 splash activity 종료
        Handler().postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, SPLASH_VIEW_TIME)
    }
}