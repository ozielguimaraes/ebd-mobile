package com.admp.ebd.data.di

import com.admp.ebd.data.remote.AlunoRemoteDataSource
import com.admp.ebd.data.remote.AlunoRemoteDataSourceImpl
import com.admp.ebd.data.remote.TurmaRemoteDataSource
import com.admp.ebd.data.remote.TurmaRemoteDataSourceImpl
import org.koin.core.qualifier.named
import org.koin.dsl.module

val dataSourceModule = module {
    factory<AlunoRemoteDataSource> {
        AlunoRemoteDataSourceImpl(
//            api = get(named("SERVICE")),
//            networkReachability = get()
        )
    }
    factory<TurmaRemoteDataSource> {
        TurmaRemoteDataSourceImpl(
//            api = get(named("SERVICE")),
//            networkReachability = get()
        )
    }
}