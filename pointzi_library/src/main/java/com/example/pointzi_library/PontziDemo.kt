package com.example.pointzi_library

import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.pointzi_library.databinding.FabBinding
import java.text.SimpleDateFormat
import java.util.*


/**
 *@Created by Yerimah on 5/21/2021.
 */


class PontziDemo(private val context: AppCompatActivity, private val rootView: ViewGroup) {

    private lateinit var fabBinding: FabBinding

    fun inflateButton() {
        fabBinding = FabBinding.inflate(LayoutInflater.from(context))
        fabBinding.fab.setOnClickListener { loadDialog() }
        val params = RelativeLayout.LayoutParams(
            RelativeLayout.LayoutParams.WRAP_CONTENT,
            RelativeLayout.LayoutParams.WRAP_CONTENT
        )
        val screenWidth: Int = context.resources.displayMetrics.widthPixels
        val screenHeight: Int = context.resources.displayMetrics.heightPixels
        params.setMargins(screenWidth - 150,   screenHeight - 100, 0, 0)
        fabBinding.fab.layoutParams = params
        rootView.addView(fabBinding.fab)
    }


    private fun loadDialog() {

        val installTime = SimpleDateFormat("dd MMM yy", Locale.getDefault()).format(getInstallTime(context))
        val currentTime = SimpleDateFormat("hh:mm aa dd MMM yy", Locale.getDefault()).format(Date())
        val installText = "Library Installed on $installTime"
        val currentText = "Current time:\n$currentTime"
        MainDialog(context, installText, currentText).show()

    }

}
