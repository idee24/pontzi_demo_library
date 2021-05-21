package com.example.pointzi_library

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Window
import com.example.pointzi_library.databinding.DialogMainBinding

/**
 *Created by Yerimah on 5/21/2021.
 */
class MainDialog(appContext: Context,
                 private val installText: String,
                 private val currentTime: String): Dialog(appContext) {

    private lateinit var binding: DialogMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        binding = DialogMainBinding.inflate(LayoutInflater.from(context))
        setContentView(binding.root)
        binding.installDateTextView.text = installText
        binding.dateTextView.text = currentTime

    }
}