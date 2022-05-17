package com.admp.ebd.ioc

import com.admp.ebd.ui.chamada.SelecionarClasseViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel {
        SelecionarClasseViewModel(
            application = get(),
            turmaRemoteDataSource = get()
        )
    }
}