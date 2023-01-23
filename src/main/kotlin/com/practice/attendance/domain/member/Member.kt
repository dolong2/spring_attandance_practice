package com.practice.attendance.domain.member

import com.practice.attendance.global.entity.BaseIdEntity
import jakarta.persistence.*

@Entity
@Table
class Member(
    val email: String,
    val grade: Int,
    val classNum: Int,
    val num: Int,
    val name: String,
    @Enumerated(EnumType.STRING)
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "UserRole", joinColumns = [JoinColumn(name = "id")])
    val roles: MutableList<Role> = mutableListOf(),
): BaseIdEntity()