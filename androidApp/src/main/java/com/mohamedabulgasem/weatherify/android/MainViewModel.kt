package com.mohamedabulgasem.weatherify.android

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mohamedabulgasem.weatherify.Weatherify
import com.mohamedabulgasem.weatherify.model.WeatherForecast
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    val weatherForecast = mutableStateOf<WeatherForecast?>(null)

    private val weatherify: Weatherify by lazy {
        Weatherify.create(
            apiKey = BuildConfig.API_KEY,
            withCachingEnabled = true
        )
    }

    init {
        fetchWeatherForecast()
    }

    private fun fetchWeatherForecast() = runCoroutine {
        runCatching {
            weatherify.getWeatherForecast(
                city = "Cape Town",
                days = 2,
                withAirQuality = true
            )
        }
            .onSuccess {
                weatherForecast.value = it
            }
            .onFailure { error ->
                Log.e(TAG, "Error while fetching weather forecast: ${error.message}")
            }
    }

    private fun runCoroutine(
        block: suspend CoroutineScope.() -> Unit
    ) = viewModelScope.launch(block = block)

    companion object {
        private const val TAG = "MainViewModel"
    }
}
