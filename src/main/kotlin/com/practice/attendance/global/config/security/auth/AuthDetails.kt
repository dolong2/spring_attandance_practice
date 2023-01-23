package com.practice.attendance.global.config.security.auth

import com.practice.attendance.domain.member.Member
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.util.Collections

class AuthDetails(
    private val user: Member
): UserDetails {
    override fun getAuthorities(): MutableCollection<out GrantedAuthority>
        = mutableListOf()

    override fun getPassword(): String? =
        null

    override fun getUsername(): String =
        user.email

    override fun isAccountNonExpired(): Boolean =
        true

    override fun isAccountNonLocked(): Boolean =
        true


    override fun isCredentialsNonExpired(): Boolean =
        true

    override fun isEnabled(): Boolean =
        isAccountNonExpired && isAccountNonLocked && isCredentialsNonExpired
}