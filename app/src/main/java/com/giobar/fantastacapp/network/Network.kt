package com.giobar.fantastacapp.network

import com.giobar.fantastacapp.models.response.LoginJson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Network {

    fun getLoginJson(callback: Callback<LoginJson>){
        instance.getLoginJson().enqueue(callback)
    }

    companion object {
        private val instance: RetrofitAPI by lazy { generateFCMInstance() }

        private fun generateFCMInstance(): RetrofitAPI {
            val client = OkHttpClient().newBuilder().build()
            val gson = GsonBuilder().create()

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .baseUrl(NetworkConstants.baseUrl)
                .build()

            return retrofit.create(RetrofitAPI::class.java)
        }
    }
}