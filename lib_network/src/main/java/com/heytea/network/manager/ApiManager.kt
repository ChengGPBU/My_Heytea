package com.heytea.network.manager

import com.heytea.network.api.ApiInterface

object ApiManager {
    val api by lazy { HttpManager.create(ApiInterface::class.java) }
}