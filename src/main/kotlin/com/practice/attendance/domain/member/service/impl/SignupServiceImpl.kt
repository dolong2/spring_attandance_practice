package com.practice.attendance.domain.member.service.impl

import com.practice.attendance.domain.member.Member
import com.practice.attendance.domain.member.Role
import com.practice.attendance.domain.member.repository.MemberRepository
import com.practice.attendance.domain.member.service.SignupService
import com.practice.attendance.domain.member.service.dto.SignupDto
import com.practice.attendance.global.annotation.TransactionService
import com.practice.attendance.global.util.GAuthProperties
import gauth.GAuth
import java.util.Collections

@TransactionService
class SignupServiceImpl(
    private val memberRepository: MemberRepository,
    private val gAuthProperties: GAuthProperties,
) : SignupService {
    override fun execute(signupDto: SignupDto) : Long{
        val accessToken = GAuth.generateToken(
            signupDto.email,
            signupDto.password,
            gAuthProperties.clientId,
            gAuthProperties.clientSecret,
            gAuthProperties.redirectURI
        ).accessToken
        val userInfo = GAuth.getUserInfo(accessToken)
        val member = Member(
            email = userInfo.email,
            name = userInfo.name,
            grade = userInfo.grade,
            classNum = userInfo.classNum,
            num = userInfo.num,
            roles = Collections.singletonList(Role.valueOf(userInfo.role))
        )
        return memberRepository.save(member).id
    }
}