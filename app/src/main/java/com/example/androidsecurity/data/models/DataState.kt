package com.example.androidsecurity.data.models

sealed class DataState<out R> {
    data class Success<out T>(val data: T?) : DataState<T>()
    data class Error(val exception: Exception) : DataState<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$exception]"
        }
    }
}