package com.heytea.framework.ext

import android.app.Activity
import android.content.Intent

inline fun <reified T: Activity> Activity.startActiity() {
    startActivity(Intent(this, T::class.java))
}