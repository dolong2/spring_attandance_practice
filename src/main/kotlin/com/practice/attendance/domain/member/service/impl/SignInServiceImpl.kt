package com.practice.attendance.domain.member.service.impl

import com.practice.attendance.domain.member.exception.MemberNotFindException
import com.practice.attendance.domain.member.repository.MemberRepository
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
    private val gauthProperites: GAuthProperties,
) : SignInService {
    override fun execute(signInDto: SignInDto): TokenDto {
        GAuth.generateToken(
            signInDto.email,
            signInDto.password,
            gauthProperites.clientId,
            gauthProperites.clientSecret,
            gauthProperites.redirectURI
        )
        if (!memberRepository.existsByEmail(signInDto.email))
            throw MemberNotFindException()
        return TokenDto(
            accessToken = tokenProvider.generateAccessToken(signInDto.email),
            refreshToken = tokenProvider.generateRefreshToken(signInDto.email),
            expiresAt = tokenProvider.accessExpiredTime
        )
    }
}