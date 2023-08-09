package com.dahlos.foodnotes.utils

sealed class ResultViewState {
    object Initial : ResultViewState()
    object Loading : ResultViewState()
    object Empty : ResultViewState()
    data class Success(val data: Any) : ResultViewState()
    data class Error(val e: Exception) : ResultViewState()
}
