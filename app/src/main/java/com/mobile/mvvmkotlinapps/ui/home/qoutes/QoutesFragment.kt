package com.mobile.mvvmkotlinapps.ui.home.qoutes

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import org.kodein.di.android.x.kodein
import com.mobile.mvvmkotlinapps.R
import com.mobile.mvvmkotlinapps.util.Coroutine
import com.mobile.mvvmkotlinapps.util.toast
import org.kodein.di.KodeinAware
import org.kodein.di.generic.instance

class QoutesFragment : Fragment(),KodeinAware {
    override val kodein by kodein()

    private val factory: QoutesViewModelFactory by instance()


    private lateinit var viewModel: QoutesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.qoutes_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this, factory).get(QoutesViewModel::class.java)
        Coroutine.main{
            val qoutes = viewModel.qoutes.await()
            qoutes.observe(viewLifecycleOwner, Observer {
                context?.toast(it.size.toString())
            })
        }
    }

}
