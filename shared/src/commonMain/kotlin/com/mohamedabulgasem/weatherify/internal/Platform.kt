package com.mohamedabulgasem.weatherify.internal

import io.ktor.client.*

internal expect val platform: Platform

internal interface Platform {

    val name: String

    fun getHttpClient(config: HttpClientConfig<*>.() -> Unit): HttpClient
}
