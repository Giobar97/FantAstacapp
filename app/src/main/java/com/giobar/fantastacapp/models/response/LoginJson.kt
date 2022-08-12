package com.giobar.fantastacapp.models.response

import com.google.gson.annotations.SerializedName

data class LoginJson (
    @SerializedName("data")
    val users: ArrayList<User>
)

data class User(
    @SerializedName("id")
    val id: String,
    @SerializedName("username")
    val username: String,
    @SerializedName("md5password")
    val password: String
)