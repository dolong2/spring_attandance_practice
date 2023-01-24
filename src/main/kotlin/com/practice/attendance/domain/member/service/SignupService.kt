package com.practice.attendance.domain.member.service

import com.practice.attendance.domain.member.service.dto.SignupDto

interface SignupService {
    fun execute(signupDto: SignupDto) : Long
}