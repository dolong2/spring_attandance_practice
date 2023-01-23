package com.practice.attendance.domain.member.service

import com.practice.attendance.domain.member.service.dto.req.SignupReqDto

interface SignupService {
    fun execute(signupReqDto: SignupReqDto) : Long
}