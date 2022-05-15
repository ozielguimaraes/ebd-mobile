package com.admp.ebd.data.remote

import com.admp.ebd.data.remote.entities.aluno.AlunoRemoteEntity
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface EbdApi {
    @GET
    suspend fun obterAlunos(
        @Url endpoint: String,
        @Query("turmaId") turmaId: Int
    ): Response<List<AlunoRemoteEntity>>
}