package com.practice.attendance.global.config.security.auth

import com.practice.attendance.domain.member.repository.MemberRepository
import com.practice.attendance.global.annotation.ReadOnlyService
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService

@ReadOnlyService
class AuthDetailsService(
    private val userRepository: MemberRepository
): UserDetailsService {
    override fun loadUserByUsername(username: String): UserDetails {
        val user = userRepository.findByEmail(username)
            ?: throw RuntimeException()
        return AuthDetails(user)
    }

}