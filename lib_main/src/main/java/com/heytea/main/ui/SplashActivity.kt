package com.heytea.main.ui

import android.content.Context
import android.os.Bundle
import android.os.CountDownTimer
import com.heytea.common.provider.MainServiceProvider
import com.heytea.framework.base.BaseDataBindActivity
import com.heytea.framework.ext.immersionStatusBar
import com.heytea.main.R
import com.heytea.main.databinding.ActivitySplashBinding

class SplashActivity : BaseDataBindActivity<ActivitySplashBinding>() {

    private lateinit var countdownTimer: CountDownTimer


    override fun initView(savedInstanceState: Bundle?) {
        immersionStatusBar(true, android.R.color.transparent, true, 0.2f)
        mBinding.tvSkip.setOnClickListener {
            MainServiceProvider.toMain(this)
        }
        startCountdown(3000, this) // 5秒倒计时
    }

    private fun startCountdown(duration: Long, context: Context) {
        countdownTimer = object : CountDownTimer(duration, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                // 这里可以更新倒计时 UI，例如更新 TextView
                mBinding.tvSkip.text = getString (R.string.splash_time, (millisUntilFinished / 1000).toString())
            }

            override fun onFinish() {
                // 倒计时结束，跳转到主界面
                MainServiceProvider.toMain(context, 0)
                finish()
            }
        }.start()
    }


    override fun onDestroy() {
        super.onDestroy()
        // 确保闪屏 Activity 销毁时停止倒计时
        countdownTimer.cancel()
    }


}