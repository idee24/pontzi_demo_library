package com.example.pointzi_challange

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import com.example.pointzi_library.PontziDemo

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        PontziDemo(this, window.decorView as ViewGroup).inflateButton()
    }
}