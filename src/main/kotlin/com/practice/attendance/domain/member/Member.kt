package com.practice.attendance.domain.member

import com.practice.attendance.global.entity.BaseIdEntity
import jakarta.persistence.*

@Entity
class Member(
    val email: String,
    val password: String,
    val name: String,
    @Enumerated(EnumType.STRING) @Column(name = "Role")
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "Role", joinColumns = [JoinColumn(name = "member_id")])
    val roles: MutableList<Role>,
): BaseIdEntity()