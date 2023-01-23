package com.practice.attendance.domain.member.service.dto.req

import com.practice.attendance.domain.member.presentation.dto.req.SignupReq

class SignupReqDto (
    val email: String,
    val password: String,
) {
    constructor(signupReq: SignupReq): this(
        email = signupReq.email,
        password = signupReq.password
    )
}