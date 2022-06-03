package com.admp.ebd.data.remote

import com.admp.ebd.data.remote.entities.turma.TurmaRemoteEntity
import com.admp.ebd.infrastructure.network.ResultWrapper

class TurmaRemoteDataSourceImpl : TurmaRemoteDataSource {
    override suspend fun obterTodasTurmas(): ResultWrapper<List<TurmaRemoteEntity>?> {
        return ResultWrapper.Success(
            listOf(
                TurmaRemoteEntity(1, "Mensageiros da fé", 11, 12),
                TurmaRemoteEntity(2, "Vencedores", 13, 14)
            )
        )
    }
}