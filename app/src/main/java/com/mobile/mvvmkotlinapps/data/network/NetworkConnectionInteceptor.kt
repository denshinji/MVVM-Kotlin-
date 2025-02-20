package com.mobile.mvvmkotlinapps.data.network

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import com.mobile.mvvmkotlinapps.util.NoInternetException
import okhttp3.Interceptor
import okhttp3.Response

class NetworkConnectionInteceptor(
    context: Context
) : Interceptor {
    private val applicationContext = context.applicationContext
    override fun intercept(chain: Interceptor.Chain): Response {
    if(!isInternetAvaible()){
        throw NoInternetException("Make sure you have an active data connection")

    }
        return chain.proceed(chain.request())

    }

    private fun isInternetAvaible() : Boolean {
        var result = false
        val connectivityManager = applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
        connectivityManager?.let {
            it.getNetworkCapabilities(connectivityManager.activeNetwork)?.apply {
                result = when {
                    hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                    hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                    else -> false
                }
            }
        }
        return result
    }
}