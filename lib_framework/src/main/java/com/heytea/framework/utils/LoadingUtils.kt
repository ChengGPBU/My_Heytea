package com.heytea.framework.utils

import android.app.Activity
import android.content.Context
import android.text.TextUtils
import com.heytea.framework.R
import com.heytea.framework.loading.CenterLoadingView

class LoadingUtils(private val mContext: Context) {
    private var loadView: CenterLoadingView? = null

    fun showLoading(text: String?) {
        if (loadView == null) {
            loadView = CenterLoadingView(mContext, R.style.loading_dialog)
        }
        if (loadView?.isShowing == true) {
            loadView?.dismiss()
        }
        if (TextUtils.isEmpty(text)) {
            loadView?.setTitle(text as CharSequence)
        }
        if (mContext is Activity && mContext.isFinishing) {
            return
        }
        loadView?.show()
    }


    fun dismissLoading() {
        if (mContext is Activity && mContext.isFinishing) return
        loadView?.let {
            if (it.isShowing) {
                it.dismiss()
            }
        }
    }
}