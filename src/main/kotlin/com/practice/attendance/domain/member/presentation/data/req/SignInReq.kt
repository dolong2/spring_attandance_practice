package com.practice.attendance.domain.member.presentation.data.req

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Pattern

class SignInReq (
    @field:NotBlank
    @field:Pattern(regexp = "^[a-zA-Z0-9]+@gsm.hs.kr$")
    val email: String,
    @field:NotBlank
    val password: String,
)