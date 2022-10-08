package com.mohamedabulgasem.weatherify.internal

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

internal class ApiClient(private val apiKey: String) {

    private val httpClient: HttpClient by lazy {
        platform.getHttpClient {
            // Auto serialise/deserialise the content when sending requests and receiving responses
            install(ContentNegotiation) {
                json(Json {
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                })
            }
        }
    }

    suspend inline fun <reified T> get(
        path: String,
        queryParams: List<Pair<String, String>> = emptyList()
    ): T {
        val httpsResponse = httpClient.get {
            url {
                protocol = URLProtocol.HTTP
                host = API_HOST
                path(path)
                // Query params
                parameters.append(PARAM_API_KEY, apiKey)

                queryParams.forEach {
                    parameters.append(it.first, it.second)
                }
            }
        }
        return httpsResponse.body()
    }

    companion object {
        private const val API_HOST = "api.weatherapi.com/v1"
        private const val PARAM_API_KEY = "key"
    }
}
