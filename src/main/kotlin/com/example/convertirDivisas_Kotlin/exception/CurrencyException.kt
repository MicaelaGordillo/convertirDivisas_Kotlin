package com.example.convertirDivisas_Kotlin.exception

class CurrencyException : RuntimeException {
    constructor(message: String?) : super(message) {}
    constructor(message: String?, cause: Throwable?) : super(message, cause) {}
}