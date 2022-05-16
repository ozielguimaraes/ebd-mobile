package com.admp.ebd.ui.chamada

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.admp.ebd.data.remote.TurmaRemoteDataSource
import com.admp.ebd.data.remote.entities.turma.TurmaRemoteEntity
import com.admp.ebd.domain.exceptions.TurmaNaoEncontradaException
import com.admp.ebd.infrastructure.network.ResultWrapper
import com.admp.ebd.ui.BaseViewModel
import kotlinx.coroutines.launch

class SelecionarClasseViewModel(
    application: Application,
    private val turmaRemoteDataSource: TurmaRemoteDataSource
) : BaseViewModel(application) {

    private val _turmasLiveData = MutableLiveData<List<TurmaRemoteEntity>>()
    val turmasLiveData: LiveData<List<TurmaRemoteEntity>> = _turmasLiveData

    fun carregarListaTurma() =
        viewModelScope.launch {
            // TODO Add use case to do the research
            when (val result = turmaRemoteDataSource.obterTodasTurmas()) {
                is ResultWrapper.Success -> {
                    //TODO convert to local class? instead of using remote entity?

                    result.data?.let { turmas ->
                        if (turmas.isEmpty()){
                            updateErrorLiveData(ResultWrapper.Error(TurmaNaoEncontradaException()))
                        }
                        else _turmasLiveData.postValue(turmas)
                    }
                }
                is ResultWrapper.Error -> updateErrorLiveData(result)
            }
        }
}