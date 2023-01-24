package com.practice.attendance.domain.member.presentation.data.res

import com.fasterxml.jackson.annotation.JsonFormat
import com.practice.attendance.domain.member.service.dto.TokenDto
import java.time.ZonedDateTime

class SignInRes (
    val accessToken: String,
    val refreshToken: String,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    val expiresAt: ZonedDateTime
) {
    constructor(tokenDto: TokenDto): this(
        accessToken = tokenDto.accessToken,
        refreshToken = tokenDto.refreshToken,
        expiresAt = tokenDto.expiresAt
    )
}