package com.admp.ebd

import android.app.Application
import com.admp.ebd.data.di.dataSourceModule
import com.admp.ebd.ioc.EbdModules
import com.admp.ebd.ioc.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import timber.log.Timber

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        setupTimber()
        setupKoin()
    }

    private fun setupTimber() {
        if(Timber.treeCount != 0) return

        Timber.plant(Timber.DebugTree())
    }

    private fun setupKoin() {
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@MyApp)
        }
        loadKoinModules(listOf(presentationModule, dataSourceModule))
    }
}