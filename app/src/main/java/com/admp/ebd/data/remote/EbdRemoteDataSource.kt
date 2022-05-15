package com.admp.ebd.data.remote

import com.admp.ebd.data.remote.entities.aluno.AlunoRemoteEntity
import com.admp.ebd.infrastructure.network.ResultWrapper

interface EbdRemoteDataSource {
    suspend fun getAlunos(turmaId: Int): ResultWrapper<List<AlunoRemoteEntity>?>
}