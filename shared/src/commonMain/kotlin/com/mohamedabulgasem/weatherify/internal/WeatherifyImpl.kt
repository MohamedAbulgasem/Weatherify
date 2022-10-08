package com.mohamedabulgasem.weatherify.internal

import com.mohamedabulgasem.weatherify.Weatherify

internal class WeatherifyImpl(
    apiKey: String,
    withCachingEnabled: Boolean
) : Weatherify {

    private val apiClient: ApiClient by lazy { ApiClient(apiKey) }

    override fun getWeatherForecast() = "Hello from the KMM side!"
}
