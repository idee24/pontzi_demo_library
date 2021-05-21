package com.example.pointzi_library

import android.content.Context
import androidx.preference.PreferenceManager
import java.util.*

/**
 *@Created by Yerimah on 5/21/2021.
 */

val FIRST_TIME_KEY = "first_time_key"
val FIRST_TIME = "first_time"

fun isFirstTime(context: Context) {
    val prefs = PreferenceManager.getDefaultSharedPreferences(context)
    val firstTime = prefs.getBoolean(FIRST_TIME, true)
    if (firstTime) {
        prefs.edit().putBoolean(FIRST_TIME, false).apply()
        prefs.edit().putLong(FIRST_TIME_KEY, Date().time).apply()
    }
}

fun getInstallTime(context: Context): Long {
    val prefs = PreferenceManager.getDefaultSharedPreferences(context)
    isFirstTime(context)
    return prefs.getLong(FIRST_TIME_KEY, Date().time)
}
