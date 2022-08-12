package com.giobar.fantastacapp.network

import com.giobar.fantastacapp.models.response.LoginJson
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RetrofitAPI {
    @GET(NetworkConstants.loginEndpoint)
    fun getLoginJson(): Call<LoginJson>
}