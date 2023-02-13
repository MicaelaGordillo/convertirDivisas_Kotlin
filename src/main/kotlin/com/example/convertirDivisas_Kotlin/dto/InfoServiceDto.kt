package com.example.convertirDivisas_Kotlin.dto

import com.fasterxml.jackson.annotation.JsonProperty
import java.math.BigDecimal
import java.math.BigInteger

data class InfoServiceDto (
    @JsonProperty("timestamp")
    private val timestamp: BigInteger,
    @JsonProperty("rate")
    private val rate: BigDecimal
)