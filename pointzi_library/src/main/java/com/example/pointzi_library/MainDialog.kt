package com.example.pointzi_library

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.os.Looper.loop
import android.view.Gravity
import android.view.LayoutInflater
import android.view.Window
import android.view.WindowManager
import com.bumptech.glide.Glide
import com.example.pointzi_library.databinding.DialogMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

/**
 *Created by Yerimah on 5/21/2021.
 */
class MainDialog(private val appContext: Context,
                 private val installText: String,
                 private val currentTime: String): Dialog(appContext, R.style.CustomDialogTheme) {

    private lateinit var binding: DialogMainBinding
    private val imageUrl = "https://images.unsplash.com/photo-1472457897821-70d3819a0e24?ixid=Mnw" +
            "xMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=749&q=80"
    private var isActive = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window?.setLayout(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT)
        window?.setGravity(Gravity.CENTER)
        binding = DialogMainBinding.inflate(LayoutInflater.from(context))
        setContentView(binding.root)
        initViews()

    }

    private fun initViews() {
        binding.installDateTextView.text = installText
        binding.dateTextView.text = currentTime
        Glide.with(appContext).load(imageUrl).error(R.drawable.image).placeholder(R.drawable.loader_).into(binding.imageView)

        CoroutineScope(IO).launch {
            delay(1000)
            CoroutineScope(Main).launch {
                if (isActive) {
                    val currentTime = SimpleDateFormat("hh:mm aa ss  dd MMM yy", Locale.getDefault()).format(Date())
                    val currentText = "Current time:\n$currentTime"
                    binding.dateTextView.text = currentText
                    loop()
                }
            }
        }
    }

    override fun onStop() {
        isActive = false
        super.onStop()

    }
}