package com.mobile.mvvmkotlinapps.ui.auth

import android.view.View
import androidx.lifecycle.ViewModel
import com.mobile.mvvmkotlinapps.data.repositories.UserRepository

class AuthViewModel : ViewModel() {
    var email : String? = null
    var password : String? = null

    var authListener : AuthListener? =null

    fun onLoginButtonClick(View : View){
    authListener?.onStarted()
        if(email.isNullOrEmpty() || password.isNullOrEmpty()){
            authListener?.onFailure("Invalid Email Or Password")
            return
        }
       val loginResponse = UserRepository().userLogin(email!! , password!!)
        authListener?.onSuccess(loginResponse)

    }
}