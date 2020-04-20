package com.mobile.mvvmkotlinapps.ui.auth

import androidx.lifecycle.LiveData
import com.mobile.mvvmkotlinapps.data.db.entities.User

interface AuthListener {
    fun onStarted()
    fun onSuccess(user : User)
    fun onFailure(meesage:String)
}