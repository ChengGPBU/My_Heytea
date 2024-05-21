package com.heytea.main.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.heytea.common.constant.KEY_INDEX
import com.heytea.common.constant.MAIN_ACTIVITY_HOME
import com.heytea.framework.toast.TipsToast
import com.heytea.framework.utils.AppExit
import com.heytea.main.R

@Route(path = MAIN_ACTIVITY_HOME)
class MainActivity : AppCompatActivity() {

    companion object {
        fun start(context: Context, index: Int = 0) {
            val intent = Intent(context, MainActivity::class.java)
            intent.putExtra(KEY_INDEX, index)
            context.startActivity(intent)
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onBackPressed() {
        AppExit.onBackPressed(
            this,
            { TipsToast.showTips(getString(R.string.app_exit_one_more_press)) }
        )
    }


}