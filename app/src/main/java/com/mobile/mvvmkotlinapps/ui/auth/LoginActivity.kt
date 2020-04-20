package com.mobile.mvvmkotlinapps.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.mobile.mvvmkotlinapps.R
import com.mobile.mvvmkotlinapps.databinding.ActivityLoginBinding
import com.mobile.mvvmkotlinapps.util.hide
import com.mobile.mvvmkotlinapps.util.show
import com.mobile.mvvmkotlinapps.util.toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(),AuthListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding : ActivityLoginBinding = DataBindingUtil.setContentView(this,R.layout.activity_login)
        val viewModel = ViewModelProviders.of(this).get(AuthViewModel::class.java)
        binding.viewmodel = viewModel

        viewModel.authListener = this
    }

    override fun onStarted() {
        progress_bar.show()
    }

    override fun onSuccess(loginResponse: LiveData<String>) {
       loginResponse.observe(this, Observer {
           progress_bar.hide()
           toast(it) })

    }

    override fun onFailure(meesage: String) {
       progress_bar.hide()
        toast("Login Failure")

    }
}
