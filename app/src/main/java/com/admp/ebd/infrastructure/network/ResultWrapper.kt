package com.admp.ebd.infrastructure.network

sealed class ResultWrapper<out Response>{
    data class Success<out Response>(val data: Response, val code: Int = 0) : ResultWrapper<Response>()
    data class Error(val exception: Exception, val code: Int = 0) : ResultWrapper<Nothing>()
}