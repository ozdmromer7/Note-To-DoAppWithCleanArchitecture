package com.ozdmromer7.noteappcleanarchitecture.domain.util

sealed class OrderType{
    data object Ascending:OrderType()
    data object Descending:OrderType()
}
