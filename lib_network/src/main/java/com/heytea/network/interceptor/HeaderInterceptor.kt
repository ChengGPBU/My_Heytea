package com.heytea.network.interceptor

import com.heytea.framework.log.LogUtil
import com.heytea.network.constant.ARTICLE_WEBSITE
import com.heytea.network.constant.COIN_WEBSITE
import com.heytea.network.constant.COLLECTION_WEBSITE
import com.heytea.network.constant.KEY_COOKIE
import com.heytea.network.constant.NOT_COLLECTION_WEBSITE
import com.heytea.network.manager.CookiesManager
import okhttp3.Interceptor
import okhttp3.Response

class HeaderInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val newBuilder = request.newBuilder()
        newBuilder.addHeader("Content-type", "application/json; charset=utf-8")
        val host = request.url().host()
        val url = request.url().toString()


        if (!host.isNullOrEmpty()  && (url.contains(COLLECTION_WEBSITE)
                    || url.contains(NOT_COLLECTION_WEBSITE)
                    || url.contains(ARTICLE_WEBSITE)
                    || url.contains(COIN_WEBSITE))) {
            val cookies = CookiesManager.getCookies()
            LogUtil.e("HeaderInterceptor:cookies:$cookies")
            if (!cookies.isNullOrEmpty()) {
                newBuilder.addHeader(KEY_COOKIE, cookies)
            }
        }

        return chain.proceed(newBuilder.build())
    }
}