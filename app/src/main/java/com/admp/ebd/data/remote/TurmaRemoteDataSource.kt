package com.admp.ebd.data.remote

import com.admp.ebd.data.remote.entities.turma.TurmaRemoteEntity
import com.admp.ebd.infrastructure.network.ResultWrapper

interface TurmaRemoteDataSource {
    suspend fun obterTodasTurmas(): ResultWrapper<List<TurmaRemoteEntity>?>
}