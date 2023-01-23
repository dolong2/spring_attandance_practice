package com.practice.attendance.global.util

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "gauth")
class GAuthProperties(
    val clientId: String,
    val clientSecret: String,
    val redirectURI: String,
)