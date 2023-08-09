package com.dahlos.foodnotes.utils

sealed class ResultViewState<out R> {
    object Initial : ResultViewState<Nothing>()
    object Loading : ResultViewState<Nothing>()
    data class Success<out T>(val data: T) : ResultViewState<T>()
    data class Error(val e: Exception) : ResultViewState<Nothing>()
}
