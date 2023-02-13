package com.example.convertirDivisas_Kotlin.api

import com.example.convertirDivisas_Kotlin.bl.CurrencyBl
import com.example.convertirDivisas_Kotlin.dto.RequestServiceDto
import com.example.convertirDivisas_Kotlin.dto.ResponseServiceDto
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.math.BigDecimal

@RestController
@RequestMapping("/api/currency")
class CurrencyApi(private val currencyBl: CurrencyBl) {
    private val LOGGER = LoggerFactory.getLogger(CurrencyApi::class.java)

    @GetMapping("/exchange")
    fun exchangeRate(
        @RequestParam amount: BigDecimal,
        @RequestParam from: String,
        @RequestParam to: String
    ): ResponseServiceDto {
        val requestServiceDto = RequestServiceDto(amount, from, to)
        LOGGER.info("Processing conversion request amount: $amount from: $from to: $to")
        return currencyBl.exchangeRate(requestServiceDto)
    }
}