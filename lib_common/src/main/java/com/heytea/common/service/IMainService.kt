package com.heytea.common.service

import android.content.Context
import com.alibaba.android.arouter.facade.template.IProvider

interface IMainService : IProvider {

    /**
     * 跳转主页
     * @param context
     * @param index tab位置
     */
    fun toMain(context: Context, index: Int)


    /**
     * 跳转文章详情
     * @param url
     * @param title tab位置
     */
    fun toArticleDetail(context: Context, url: String, title: String)
}