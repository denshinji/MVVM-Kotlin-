package com.mobile.mvvmkotlinapps.ui.home.profile

import androidx.lifecycle.ViewModel
import com.mobile.mvvmkotlinapps.data.repositories.UserRepository

class ProfileViewModel(
    repository: UserRepository
) : ViewModel() {

    val user = repository.getUser()

}
