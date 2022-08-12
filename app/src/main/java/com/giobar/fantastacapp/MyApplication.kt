package com.giobar.fantastacapp

import android.app.Application
import com.giobar.fantastacapp.network.Network

class MyApplication: Application() {
    companion object{
        val network = Network()
    }
}