package com.mohamedabulgasem.weatherify.internal

import io.ktor.client.*
import platform.UIKit.UIDevice

internal actual val platform: Platform = IOSPlatform()

private class IOSPlatform : Platform {

    override val name: String =
        "iOS ${UIDevice.currentDevice.systemVersion}"

    override fun getHttpClient(
        config: HttpClientConfig<*>.() -> Unit
    ) = HttpClient(config)
}
