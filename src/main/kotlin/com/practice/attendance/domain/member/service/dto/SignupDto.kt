package com.practice.attendance.domain.member.service.dto

import com.practice.attendance.domain.member.presentation.data.req.SignupReq

data class SignupDto (
    val email: String,
    val password: String,
) {
    constructor(signupReq: SignupReq): this(
        email = signupReq.email,
        password = signupReq.password
    )
}