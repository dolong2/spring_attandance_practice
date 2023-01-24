package com.practice.attendance.domain.member.presentation

import com.practice.attendance.domain.member.presentation.data.req.SignInReq
import com.practice.attendance.domain.member.presentation.data.req.SignupReq
import com.practice.attendance.domain.member.presentation.data.res.SignInRes
import com.practice.attendance.domain.member.service.SignInService
import com.practice.attendance.domain.member.service.SignupService
import com.practice.attendance.domain.member.service.dto.SignInDto
import com.practice.attendance.domain.member.service.dto.SignupDto
import com.practice.attendance.domain.member.service.dto.TokenDto
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auth")
class AuthController (
    private val signupService: SignupService,
    private val signInService: SignInService,
) {
    @PostMapping("/signup")
    fun signup(@Valid @RequestBody signupReq: SignupReq): ResponseEntity<Void>{
        signupService.execute(SignupDto(signupReq))
        return ResponseEntity.ok().build()
    }

    @PostMapping
    fun signIn(@Valid @RequestBody signInReq: SignInReq): ResponseEntity<SignInRes>{
        return ResponseEntity.ok(SignInRes(signInService.execute(SignInDto(signInReq))))
    }
}