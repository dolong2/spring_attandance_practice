package com.practice.attendance.domain.member.repository

import com.practice.attendance.domain.member.RefreshToken
import org.springframework.data.repository.CrudRepository

interface RefreshTokenRepository: CrudRepository<RefreshToken, Long> {
    fun findByUserId(userId: Long): RefreshToken?
    fun findByToken(token: String): RefreshToken?
}