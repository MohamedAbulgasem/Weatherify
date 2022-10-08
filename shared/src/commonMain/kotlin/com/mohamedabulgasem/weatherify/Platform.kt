package com.mohamedabulgasem.weatherify

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform