package com.admp.ebd.data.remote

import com.admp.ebd.data.remote.entities.aluno.AlunoRemoteEntity
import com.admp.ebd.infrastructure.network.ResultWrapper

interface AlunoRemoteDataSource {
    suspend fun obterAlunosPorTurma(turmaId: Int): ResultWrapper<List<AlunoRemoteEntity>?>
}
