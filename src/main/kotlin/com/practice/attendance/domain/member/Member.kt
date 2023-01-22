package com.practice.attendance.domain.member

import com.practice.attendance.global.entity.BaseIdEntity
import jakarta.persistence.*

@Entity
class Member(
    val email: String,
    val password: String,
    val name: String,
    val role: String,
): BaseIdEntity()