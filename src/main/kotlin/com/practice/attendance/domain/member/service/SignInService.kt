package com.practice.attendance.domain.member.service

import com.practice.attendance.domain.member.service.dto.SignInDto
import com.practice.attendance.domain.member.service.dto.TokenDto

interface SignInService {
    fun execute(signInDto: SignInDto) : TokenDto
}