package com.mohamedabulgasem.weatherify.internal

import io.ktor.client.*
import android.os.Build

internal actual val platform: Platform = AndroidPlatform()

private class AndroidPlatform : Platform {

    override val name: String =
        "Android ${Build.VERSION.SDK_INT}"

    override fun getHttpClient(
        config: HttpClientConfig<*>.() -> Unit
    ) = HttpClient(config)
}
