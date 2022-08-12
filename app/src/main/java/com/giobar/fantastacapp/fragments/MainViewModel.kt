package com.giobar.fantastacapp.fragments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.giobar.fantastacapp.MyApplication.Companion.network
import com.giobar.fantastacapp.models.response.LoginJson
import com.giobar.fantastacapp.models.response.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel: ViewModel() {
    private val mUsers = MutableLiveData<ArrayList<User>>()
    val users: LiveData<ArrayList<User>>
        get() = mUsers

    fun getUsers(){
        network.getLoginJson(object: Callback<LoginJson>{
            override fun onResponse(call: Call<LoginJson>, response: Response<LoginJson>) {
                response.body().let {
                    mUsers.postValue(it?.users)
                }
            }
            override fun onFailure(call: Call<LoginJson>, t: Throwable) {
                mUsers.postValue(arrayListOf())
            }
        })
    }

    fun resetUsersList(){
        mUsers.postValue(arrayListOf())
    }
}