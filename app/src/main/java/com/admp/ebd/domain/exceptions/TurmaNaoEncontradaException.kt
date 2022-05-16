package com.admp.ebd.domain.exceptions

class TurmaNaoEncontradaException (exception: Exception? = null) : Exception(exception) {
    override val message: String?
        get() = "Nenhuma turma foi retornada"
}