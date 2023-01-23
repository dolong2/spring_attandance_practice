package com.practice.attendance.domain.member

import org.springframework.security.core.GrantedAuthority

enum class Role : GrantedAuthority {
    ROLE_STUDENT, ROLE_TEACHER;

    override fun getAuthority(): String =
        name
}