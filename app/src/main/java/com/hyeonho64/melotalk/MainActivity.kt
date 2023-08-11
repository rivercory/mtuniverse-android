package com.hyeonho64.melotalk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val myWeb = findViewById<WebView>(R.id.webview)

        myWeb.webViewClient = WebViewClient()
        myWeb.getSettings().setSupportZoom(true);
        myWeb.getSettings().setJavaScriptEnabled(true);
        myWeb.getSettings().setLoadsImagesAutomatically(true);
        myWeb.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        myWeb.getSettings().setBuiltInZoomControls(false);
        myWeb.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);

        myWeb.apply {
            loadUrl("http://melotalk.vercel.app")
            settings.javaScriptEnabled = true
        }
    }
}