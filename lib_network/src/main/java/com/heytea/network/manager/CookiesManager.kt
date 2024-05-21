package com.heytea.network.manager

import com.heytea.common.constant.HTTP_COOKIES_INFO
import com.heytea.framework.log.LogUtil
import com.tencent.mmkv.MMKV

object CookiesManager {

    fun saveCookies(cookies: String) {
        val mmkv = MMKV.defaultMMKV()
        mmkv.encode(HTTP_COOKIES_INFO, cookies)
    }


    fun getCookies(): String? {
        val mmkv = MMKV.defaultMMKV()
        return mmkv.decodeString(HTTP_COOKIES_INFO, "")
    }


    /**
     * 清除Cookies
     * @param cookies
     */
    fun clearCookies() {
        saveCookies("")
    }


    fun encodeCookie(cookies: List<String>?): String {
        val sb = StringBuilder()
        val set = HashSet<String>()

        cookies
            ?.map { cookie ->
                cookie.split(";".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
            }
            ?.forEach {
                it.filterNot { set.contains(it) }.forEach { set.add(it) }
            }
        LogUtil.e("cookiesList:$cookies")
        val ite = set.iterator()
        while (ite.hasNext()) {
            val cookie = ite.next()
            sb.append(cookie).append(";")
        }
        val last = sb.lastIndexOf(";")
        if (sb.length - 1 == last) {
            sb.deleteCharAt(last)
        }

        return sb.toString()

    }



}