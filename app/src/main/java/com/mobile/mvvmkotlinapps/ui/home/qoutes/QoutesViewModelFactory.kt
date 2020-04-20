@file:Suppress("UNCHECKED_CAST")

package com.mobile.mvvmkotlinapps.ui.home.qoutes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mobile.mvvmkotlinapps.data.repositories.QoutesRepository
import com.mobile.mvvmkotlinapps.data.repositories.UserRepository

class QoutesViewModelFactory(
   private val repository: QoutesRepository
) : ViewModelProvider.NewInstanceFactory(){

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return QoutesViewModel(repository) as T
    }

}