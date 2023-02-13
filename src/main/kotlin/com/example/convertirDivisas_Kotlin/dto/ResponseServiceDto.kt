package com.example.convertirDivisas_Kotlin.dto

import java.math.BigDecimal
import java.sql.Timestamp

data class ResponseServiceDto (
    private val date: Timestamp,
    private val info: InfoServiceDto,
    private val query: RequestServiceDto,
    private val result: BigDecimal,
    private val success: Boolean
)