package com.example.pointzi_library

import android.R
import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.view.LayoutInflater
import android.widget.RelativeLayout
import com.example.pointzi_library.databinding.FabBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.io.File
import java.text.SimpleDateFormat
import java.util.*


/**
 *@Created by Yerimah on 5/21/2021.
 */

class PontziDemo(private val context: Context) {

    private val colorList = ColorStateList(
        arrayOf(
            intArrayOf(-R.attr.state_enabled),  // Disabled
            intArrayOf(R.attr.state_enabled)    // Enabled
        ),
        intArrayOf(
            Color.BLACK,     // The color for the Disabled state
            Color.RED        // The color for the Enabled state
        )
    )
    private lateinit var fabBinding: FabBinding

    fun inflateButton() {
        fabBinding = FabBinding.inflate(LayoutInflater.from(context))
        val relativeLayout = fabBinding.myRelativeLayout
        val fab = getFAB()
        fab.layoutParams = RelativeLayout.LayoutParams(
            RelativeLayout.LayoutParams.WRAP_CONTENT,
            RelativeLayout.LayoutParams.WRAP_CONTENT
        )
        relativeLayout.addView(fab)
    }

    private fun getFAB(): FloatingActionButton {
        val button = FloatingActionButton(context)
        button.backgroundTintList = colorList
        button.setOnClickListener { loadDialog() }
        return button
    }

    fun loadDialog() {
//        val appInfo = context.packageManager.getApplicationInfo("app.package.name", 0).sourceDir
//        val installed: Long = File(appInfo).lastModified()
        val installTime = SimpleDateFormat("dd MMM yy", Locale.getDefault()).format(Date())
        val currentTime = SimpleDateFormat("hh:mm aa dd MMM yy", Locale.getDefault()).format(Date())
        val installText = "Library Installed on $installTime"
        val currentText = "Current time:\n$currentTime"
        MainDialog(context, installText, currentText).show()

    }
}