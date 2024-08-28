package com.example.web_view

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import com.example.web_view.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.webview.loadUrl("https://www.daraz.com.bd/#?")
        binding.webview.settings.javaScriptEnabled= true

        binding.webview.webViewClient=object:WebViewClient() {

            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)

                binding.webview.visibility=View.GONE
                binding.progressBar.visibility=View.VISIBLE
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                binding.webview.visibility=View.VISIBLE
                binding.progressBar.visibility=View.GONE
            }
        }


    }

    override fun onBackPressed() {
        if (binding.webview.canGoBack()){
            binding.webview.goBack()

        }
        else{


        super.onBackPressed()
        }
    }
}