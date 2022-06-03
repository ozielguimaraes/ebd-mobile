package com.admp.ebd.ioc

import com.admp.ebd.data.di.dataSourceModule
import org.koin.core.context.loadKoinModules

object EbdModules {
    fun loadKoinModules() {
        loadKoinModules(listOf(presentationModule, dataSourceModule))
    }
}