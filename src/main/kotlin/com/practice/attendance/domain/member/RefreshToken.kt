package com.practice.attendance.domain.member

import com.practice.attendance.global.jwt.TokenProvider
import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash
import org.springframework.data.redis.core.index.Indexed

@RedisHash(value = "refreshToken", timeToLive = TokenProvider.REFRESH_EXP)
class RefreshToken(
    @Id
    @Indexed
    val userId: Long,
    @Indexed
    val token: String,
)