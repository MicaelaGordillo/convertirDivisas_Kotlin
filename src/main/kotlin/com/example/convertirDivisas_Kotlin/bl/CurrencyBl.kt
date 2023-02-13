package com.example.convertirDivisas_Kotlin.bl

import com.example.convertirDivisas_Kotlin.api.CurrencyApi
import com.example.convertirDivisas_Kotlin.dto.RequestServiceDto
import com.example.convertirDivisas_Kotlin.dto.ResponseServiceDto
import com.example.convertirDivisas_Kotlin.exception.CurrencyException
import com.fasterxml.jackson.databind.ObjectMapper
import okhttp3.OkHttpClient
import okhttp3.Request
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.math.BigDecimal

@Service
class CurrencyBl {

    private val LOGGER: Logger = LoggerFactory.getLogger(CurrencyApi::class.java)

    fun exchangeRate(request: RequestServiceDto): ResponseServiceDto {
        val amountAux: BigDecimal = request.component1()
        if (amountAux <= BigDecimal.ZERO) {
            LOGGER.info("The amount that was entered is not valid.")
            throw IllegalArgumentException("Sorry, the change could not be made. The amount entered must be greater than zero.")
        }
        LOGGER.info("Data amount: " + request.component1() + " from: " + request.component3() + " to: " + request.component2())
        val client = OkHttpClient().newBuilder().build()
        val requestApi: Request = Request.Builder()
            .url("https://api.apilayer.com/exchangerates_data/convert?to=" + request.component2() + "&from=" + request.component3() + "&amount=" + request.component1())
            .addHeader("apikey", "w0QJ1JH5U0UH7ZsTAMPvt4uKc76kPsvz")
            .method("GET", null)
            .build()
        return try {
            val response = client.newCall(requestApi).execute()
            LOGGER.info("External service")
            if (!response.isSuccessful) {
                throw CurrencyException("Error with the external service")
            }
            val body = response.body!!.string()
            val mapper = ObjectMapper()
            mapper.readValue(body, ResponseServiceDto::class.java)
        } catch (e: Exception) {
            LOGGER.error("Error with the external service", e)
            throw CurrencyException("Error with the external service")
        }
    }
}