package com.admp.ebd.data.remote

import com.admp.ebd.data.remote.entities.revista.RevistaRemoteEntity
import com.admp.ebd.infrastructure.network.ResultWrapper

interface RevistaRemoteDataSource {
    suspend fun obterRevistaPorId(revistaId: Int): ResultWrapper<List<RevistaRemoteEntity>?>
    suspend fun obterRevistasPorPeriodo(turmaId: Int, ano: Int, trimestre: Int): ResultWrapper<List<RevistaRemoteEntity>?>
}