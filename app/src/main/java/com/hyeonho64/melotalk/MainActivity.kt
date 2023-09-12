package com.hyeonho64.melotalk

import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val myWeb = findViewById<WebView>(R.id.webview)
        val layoutswiperefresh = findViewById<SwipeRefreshLayout>(R.id.layout_swipe_refresh)

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

        layoutswiperefresh.setColorSchemeResources(
            android.R.color.holo_blue_light
        );

        layoutswiperefresh.setOnRefreshListener(OnRefreshListener {
            myWeb.reload()
            layoutswiperefresh.setRefreshing(false)
        })
    }
}