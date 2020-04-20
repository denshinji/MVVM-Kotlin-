package com.mobile.mvvmkotlinapps.ui.home.qoutes

import androidx.lifecycle.ViewModel
import com.mobile.mvvmkotlinapps.data.repositories.QoutesRepository
import com.mobile.mvvmkotlinapps.util.lazyDefrred

class QoutesViewModel(
    repository: QoutesRepository
) : ViewModel() {
    val qoutes by lazyDefrred {
        repository.getQoutes()
    }
}


