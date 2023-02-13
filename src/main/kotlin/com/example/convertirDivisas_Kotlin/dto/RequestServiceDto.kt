package com.example.convertirDivisas_Kotlin.dto

import java.math.BigDecimal

data class RequestServiceDto (
    val amount: BigDecimal,
    val to: String,
    val from: String
)