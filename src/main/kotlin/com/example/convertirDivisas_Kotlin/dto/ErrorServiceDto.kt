package com.example.convertirDivisas_Kotlin.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class ErrorServiceDto (
    @JsonProperty("code")
    private val code: String,
    @JsonProperty("message")
    private val message: String
)