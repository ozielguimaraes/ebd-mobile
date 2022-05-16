package com.admp.ebd.data.remote

import com.admp.ebd.data.remote.entities.aluno.AlunoRemoteEntity
import com.admp.ebd.infrastructure.network.ResultWrapper
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class AlunoRemoteDataSourceImpl(
    private val api: EbdApi,
    networkReachability: NetworkReachability,
    dispatcher: CoroutineDispatcher = Dispatchers.IO
) : BaseRemoteDataSource(
    dispatcher = dispatcher,
    networkReachability = networkReachability
), AlunoRemoteDataSource {
    override suspend fun obterAlunosPorTurma(turmaId: Int): ResultWrapper<List<AlunoRemoteEntity>?> =
        apiCall {
            api.obterAlunos(
                endpoint = "http://escolabiblicadominical.azurewebsites.net/api/aluno",
                turmaId = turmaId
            )
        }
}
