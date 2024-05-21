package com.heytea.network.api;


import com.heytea.network.response.BaseResponse
import retrofit2.http.GET;

/**
 * @desc API接口类
 */
interface ApiInterface {
    /**
     * 登出
     * @param username  用户名
     * @param password  密码
     * @param repassword  确认密码
     */
    @GET("/user/logout/json")
    suspend fun logout(): BaseResponse<Any?>?

}