package com.heytea

import android.app.Application
import android.content.Context
import androidx.startup.Initializer
import com.alibaba.android.arouter.launcher.ARouter
import com.heytea.framework.helper.HeyteaAppHelper
import com.heytea.framework.toast.TipsToast
import com.tencent.mmkv.MMKV

class AppInitializer : Initializer<Unit> {
    override fun create(context: Context) {
        MMKV.initialize(context)
        TipsToast.init(context.applicationContext as Application)
        HeyteaAppHelper.init(context.applicationContext as Application, BuildConfig.DEBUG)
        // 这两行必须写在init之前，否则这些配置在init过程中将无效
        if (BuildConfig.DEBUG) {
            // 开启打印日志
            ARouter.openLog()
            // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
            ARouter.openDebug()
        }
        ARouter.init(context.applicationContext as Application)
    }

    override fun dependencies(): List<Class<out Initializer<*>>> = emptyList()

}