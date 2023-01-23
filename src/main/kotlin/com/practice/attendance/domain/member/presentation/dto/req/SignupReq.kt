package com.practice.attendance.domain.member.presentation.dto.req

import com.practice.attendance.domain.member.service.dto.req.SignupReqDto

class SignupReq (
    val email: String,
    val password: String,
)