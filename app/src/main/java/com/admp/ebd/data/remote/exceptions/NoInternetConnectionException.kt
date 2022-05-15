package com.admp.ebd.data.remote.exceptions

class NoInternetConnectionException : Exception() {
    override val message: String
        get() = "Sem conexão com a internet."
}