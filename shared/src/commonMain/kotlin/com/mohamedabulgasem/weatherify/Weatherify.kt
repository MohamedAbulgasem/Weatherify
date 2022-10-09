package com.mohamedabulgasem.weatherify

import com.mohamedabulgasem.weatherify.internal.WeatherifyImpl
import com.mohamedabulgasem.weatherify.model.WeatherForecast

interface Weatherify {

    suspend fun getWeatherForecast(
        city: String,
        days: Int,
        withAirQuality: Boolean = false
    ): WeatherForecast

    companion object {

        fun create(
            apiKey: String,
            withCachingEnabled: Boolean = false
        ): Weatherify {
            require(apiKey.isNotBlank()) { "API key cannot be empty!" }
            return WeatherifyImpl(
                apiKey = apiKey,
                withCachingEnabled = withCachingEnabled
            )
        }
    }
}
