package com.mobile.mvvmkotlinapps

import android.app.Application
import com.mobile.mvvmkotlinapps.data.db.AppDatabase
import com.mobile.mvvmkotlinapps.data.network.MyApi
import com.mobile.mvvmkotlinapps.data.network.NetworkConnectionInteceptor
import com.mobile.mvvmkotlinapps.data.repositories.QoutesRepository
import com.mobile.mvvmkotlinapps.data.repositories.UserRepository
import com.mobile.mvvmkotlinapps.ui.auth.AuthViewModelFactory
import com.mobile.mvvmkotlinapps.ui.home.profile.ProfileViewModelFactory
import com.mobile.mvvmkotlinapps.ui.home.qoutes.QoutesViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class MVVMAplication : Application(),KodeinAware{

    override val kodein: Kodein = Kodein.lazy {
        import(androidXModule(this@MVVMAplication))

        bind() from singleton {
            NetworkConnectionInteceptor(instance())
        }
        bind() from singleton {
            MyApi(instance())
        }

        bind() from singleton {
            AppDatabase(instance())
        }

        bind() from singleton {
            UserRepository(instance(),instance())
        }
        bind() from singleton {
            QoutesRepository(instance(),instance())
        }

        bind() from provider { AuthViewModelFactory(instance()) }
        bind() from provider {ProfileViewModelFactory(instance()) }
        bind() from provider { QoutesViewModelFactory(instance()) }
    }
}