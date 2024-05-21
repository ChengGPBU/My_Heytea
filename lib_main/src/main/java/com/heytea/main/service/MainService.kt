package com.heytea.main.service

import android.content.Context
import com.alibaba.android.arouter.facade.annotation.Route
import com.heytea.common.constant.MAIN_SERVICE_HOME
import com.heytea.common.service.IMainService
import com.heytea.main.ui.MainActivity

@Route(path = MAIN_SERVICE_HOME)
class MainService : IMainService {
    override fun toMain(context: Context, index: Int) {
        MainActivity.start(context, index)
    }

    override fun toArticleDetail(context: Context, url: String, title: String) {
    }

    override fun init(context: Context?) {
    }
}