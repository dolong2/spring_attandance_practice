package com.practice.attendance.domain.member.service.dto

import com.practice.attendance.domain.member.presentation.data.req.SignInReq

data class SignInDto(
    val email: String,
    val password: String,
) {
    constructor(signInReq: SignInReq): this(
        email = signInReq.email,
        password = signInReq.password
    )
}
