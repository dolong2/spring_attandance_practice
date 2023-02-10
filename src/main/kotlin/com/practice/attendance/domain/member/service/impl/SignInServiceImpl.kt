package com.practice.attendance.domain.member.service.impl

import com.practice.attendance.domain.member.RefreshToken
import com.practice.attendance.domain.member.exception.MemberNotFindException
import com.practice.attendance.domain.member.repository.MemberRepository
import com.practice.attendance.domain.member.repository.RefreshTokenRepository
import com.practice.attendance.domain.member.service.SignInService
import com.practice.attendance.domain.member.service.dto.SignInDto
import com.practice.attendance.domain.member.service.dto.TokenDto
import com.practice.attendance.global.annotation.ReadOnlyService
import com.practice.attendance.global.jwt.TokenProvider
import com.practice.attendance.global.util.GAuthProperties
import gauth.GAuth

@ReadOnlyService
class SignInServiceImpl(
    private val memberRepository: MemberRepository,
    private val tokenProvider: TokenProvider,
    private val gAuthProperties: GAuthProperties,
    private val refreshTokenRepository: RefreshTokenRepository,
) : SignInService {
    override fun execute(signInDto: SignInDto): TokenDto {
        GAuth.generateToken(
            signInDto.email,
            signInDto.password,
            gAuthProperties.clientId,
            gAuthProperties.clientSecret,
            gAuthProperties.redirectURI
        )
        val member = (memberRepository.findByEmail(signInDto.email)
            ?: throw MemberNotFindException())
        val refreshToken = tokenProvider.generateRefreshToken(signInDto.email)
        refreshTokenRepository.save(RefreshToken(member.id, refreshToken))
        return TokenDto(
            accessToken = tokenProvider.generateAccessToken(signInDto.email),
            refreshToken = refreshToken,
            expiresAt = tokenProvider.accessExpiredTime
        )
    }
}