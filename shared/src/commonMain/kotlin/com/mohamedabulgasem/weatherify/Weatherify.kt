package com.mohamedabulgasem.weatherify

import com.mohamedabulgasem.weatherify.internal.WeatherifyImpl

interface Weatherify {

    fun getWeatherForecast(): String

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
