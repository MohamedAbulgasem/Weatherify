package com.mohamedabulgasem.weatherify.internal

import com.mohamedabulgasem.weatherify.Weatherify
import com.mohamedabulgasem.weatherify.model.WeatherForecast

internal class WeatherifyImpl(
    apiKey: String,
    withCachingEnabled: Boolean
) : Weatherify {

    private val apiClient: ApiClient by lazy {
        ApiClient(apiKey)
    }

    override suspend fun getWeatherForecast(
        city: String,
        days: Int,
        withAirQuality: Boolean
    ): WeatherForecast {
        return apiClient.get(
            path = "v1/forecast.json",
            queryParams = listOf(
                "q" to city,
                "days" to "$days",
                "aqi" to if (withAirQuality) "yes" else "no"
            )
        )
    }
}
