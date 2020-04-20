package com.mobile.mvvmkotlinapps.data.network.responses

import com.mobile.mvvmkotlinapps.data.db.entities.User

data class AuthResponse(val isSuccessful : Boolean?,val message : String ?, val user : User?) {

}