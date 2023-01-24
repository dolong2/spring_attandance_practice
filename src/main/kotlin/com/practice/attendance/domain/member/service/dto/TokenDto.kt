package com.practice.attendance.domain.member.service.dto

import java.time.ZonedDateTime

data class TokenDto(
    val accessToken: String,
    val refreshToken: String,
    val expiresAt: ZonedDateTime
)