package com.mobile.mvvmkotlinapps.ui.auth

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.mobile.mvvmkotlinapps.R
import com.mobile.mvvmkotlinapps.data.db.entities.User
import com.mobile.mvvmkotlinapps.databinding.ActivitySingupBinding
import com.mobile.mvvmkotlinapps.ui.home.HomeActivity
import com.mobile.mvvmkotlinapps.util.hide
import com.mobile.mvvmkotlinapps.util.show
import com.mobile.mvvmkotlinapps.util.snackbar
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_login.progress_bar
import kotlinx.android.synthetic.main.activity_login.root_layout
import kotlinx.android.synthetic.main.activity_singup.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class SingupActivity : AppCompatActivity(),AuthListener,KodeinAware {

    override val kodein by kodein()
    private val factory : AuthViewModelFactory by instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding : ActivitySingupBinding = DataBindingUtil.setContentView(this,R.layout.activity_singup)
        val viewModel = ViewModelProvider(this,factory).get(AuthViewModel::class.java)
        binding.viewmodel = viewModel

        viewModel.authListener = this

        viewModel.getLoggedInUser().observe(this, Observer {user ->
            if(user != null){
                Intent(this, HomeActivity::class.java).also {
                    it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(it)
                }
            }
        })
    }

    override fun onStarted() {
        progress_bar.show()

    }

    override fun onSuccess(user: User) {
        progress_bar.hide()
    }

    override fun onFailure(meesage: String) {
        progress_bar.hide()
        root_layout.snackbar(meesage)


    }

    }

