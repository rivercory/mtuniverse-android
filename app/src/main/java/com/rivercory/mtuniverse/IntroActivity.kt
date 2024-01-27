package com.rivercory.mtuniverse

import android.content.Intent
import android.os.Bundle
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity

class IntroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.intro_activity)
        val handler = Handler()
        handler.postDelayed(Runnable {
            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 1000)
    }
}