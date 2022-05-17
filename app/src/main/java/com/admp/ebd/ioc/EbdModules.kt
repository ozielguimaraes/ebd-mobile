package com.admp.ebd.ioc

import org.koin.core.context.loadKoinModules

object EbdModules {
    fun loadKoinModules() {
        loadKoinModules(presentationModule)
    }
}