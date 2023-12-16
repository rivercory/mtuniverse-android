package com.hyeonho64.mtuniverse

import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
import com.microsoft.clarity.Clarity
import com.microsoft.clarity.ClarityConfig


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val config = ClarityConfig("jx09f1p367")
        Clarity.initialize(applicationContext, config)
        val myWeb = findViewById<WebView>(R.id.webview)
        val layoutswiperefresh = findViewById<SwipeRefreshLayout>(R.id.layout_swipe_refresh)

        myWeb.webViewClient = WebViewClient()
        myWeb.getSettings().setSupportZoom(true);
        myWeb.getSettings().setJavaScriptEnabled(true);
        myWeb.settings.javaScriptCanOpenWindowsAutomatically = true;
        myWeb.settings.domStorageEnabled = true;
        myWeb.getSettings().setLoadsImagesAutomatically(true);
        myWeb.getSettings().setBuiltInZoomControls(false);
        myWeb.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);

        myWeb.apply {
            loadUrl("https://melotalk.vercel.app")
            settings.javaScriptEnabled = true
        }

        layoutswiperefresh.setColorSchemeResources(
            R.color.primarycolor
        );

        layoutswiperefresh.setOnRefreshListener(OnRefreshListener {
            myWeb.reload()
            layoutswiperefresh.setRefreshing(false)
        })
    }
}