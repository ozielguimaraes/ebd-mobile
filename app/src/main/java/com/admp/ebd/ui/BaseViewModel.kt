package com.admp.ebd.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.admp.ebd.data.remote.entities.Error
import com.admp.ebd.infrastructure.network.ResultWrapper
import timber.log.Timber

open class BaseViewModel(application: Application): AndroidViewModel(application) {
    private val _errorLiveData = MutableLiveData<Error>()
    val errorLiveData: LiveData<Error> = _errorLiveData

    fun updateErrorLiveData(result: ResultWrapper.Error) {
        _errorLiveData.postValue(Error("Oops", "Ocorreu um erro inesperado"))
        Timber.e(result.code.toString())
        Timber.e(result.exception)
    }
}