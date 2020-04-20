package com.mobile.mvvmkotlinapps.data.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mobile.mvvmkotlinapps.data.db.AppDatabase
import com.mobile.mvvmkotlinapps.data.db.entities.Qoute
import com.mobile.mvvmkotlinapps.data.network.MyApi
import com.mobile.mvvmkotlinapps.data.network.SafeApiRequest
import com.mobile.mvvmkotlinapps.util.Coroutine
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class QoutesRepository(
    private val api: MyApi,
    private val db: AppDatabase
) : SafeApiRequest() {

    private val qoutes = MutableLiveData<List<Qoute>>()
    init {
        qoutes.observeForever{
            savedQoutes(it)

        }

    }

    private suspend fun fetchQoutes(){
       if(isFetchNeeded()){
        val response = apiRequest{ api.getQoutes() }
           qoutes.postValue(response.qoutes)

       }
    }

    suspend fun getQoutes(): LiveData<List<Qoute>>{
        return withContext(Dispatchers.IO){
            fetchQoutes()
            db.getQouteDao().getQoutes()
        }
    }

    private fun isFetchNeeded() : Boolean{
        return true

    }

    private fun savedQoutes(qoutes : List<Qoute>){
        Coroutine.io{
            db.getQouteDao().saveAllQoute(qoutes)
        }

    }
}