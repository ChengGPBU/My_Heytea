package com.heytea.framework.toast

import android.app.Application
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.heytea.framework.R
import com.heytea.framework.databinding.WidgetTipsToastBinding

object TipsToast {
    private var toast: Toast? = null
    private lateinit var mContext: Application
    private val mTaostHandler = Looper.myLooper()?.let { Handler(it) }


    private val mBinding by lazy {
        WidgetTipsToastBinding.inflate(LayoutInflater.from(mContext), null, false)
    }

    fun init(context: Application) {
        mContext = context
    }

    fun showTips(@StringRes stringId: Int) {
        val msg = mContext.getString(stringId)
        showTipsImpl(msg, Toast.LENGTH_SHORT)
    }


    fun showTips(msg: String?) {
        showTipsImpl(
            msg,
            Toast.LENGTH_SHORT
        )
    }

    fun showTips(msg: String?, duration: Int) {
        showTipsImpl(msg, duration)
    }

    fun showTips(@StringRes stringId: Int, duration: Int) {
        val msg = mContext.getString(stringId)
        showTipsImpl(msg, duration)
    }


    fun showSuccessTips(msg: String?) {
        showTipsImpl(
            msg,
            Toast.LENGTH_SHORT,
            R.mipmap.widget_toast_success
        )
    }


    fun showWarningTips(msg: String?) {
        showTipsImpl(
            msg,
            Toast.LENGTH_SHORT,
            R.mipmap.widget_toast_warning
        )
    }

    fun showWarningTips(@StringRes stringId: Int) {
        val msg = mContext.getString(stringId)
        showTipsImpl(
            msg,
            Toast.LENGTH_SHORT,
            R.mipmap.widget_toast_warning
        )
    }


    private fun showTipsImpl(msg: String?, duration: Int, @DrawableRes drawableId: Int = 0) {
        if (msg.isNullOrEmpty()) return
        toast?.let {
            cancel()
            toast = null
        }
        mTaostHandler?.postDelayed({
            try {
                toast = Toast(mContext)
                toast?.view = mBinding.root
                mBinding.tipToastTxt.setCompoundDrawablesRelativeWithIntrinsicBounds(
                    drawableId,
                    0,
                    0,
                    0
                )
                toast?.setGravity(Gravity.CENTER, 0, 0)
                toast?.duration = duration
                toast?.show()
            } catch (e: Exception) {
                e.printStackTrace()
                Log.e("show tips error", "$e")
            }
        }, 50)
    }

    private fun cancel() {
        toast?.cancel()
        mTaostHandler?.removeCallbacksAndMessages(null)
    }
}