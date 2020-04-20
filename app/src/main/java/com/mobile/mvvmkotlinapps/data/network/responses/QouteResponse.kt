package com.mobile.mvvmkotlinapps.data.network.responses

import com.mobile.mvvmkotlinapps.data.db.entities.Qoute

data class QouteResponse(
    val isSuccessful : Boolean,
    val qoutes : List<Qoute>
)