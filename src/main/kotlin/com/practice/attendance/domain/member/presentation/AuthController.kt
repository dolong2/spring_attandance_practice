package com.practice.attendance.domain.member.presentation

import com.practice.attendance.domain.member.presentation.dto.req.SignupReq
import com.practice.attendance.domain.member.service.SignupService
import com.practice.attendance.domain.member.service.dto.req.SignupReqDto
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auth")
class AuthController (
    private val signupService: SignupService
) {
    @PostMapping("/signup")
    fun signup(@RequestBody signupReq: SignupReq): ResponseEntity<Void>{
        signupService.execute(SignupReqDto(signupReq))
        return ResponseEntity.ok().build()
    }
}