package com.practice.attendance.domain.member.repository

import com.practice.attendance.domain.member.Member
import org.springframework.data.jpa.repository.JpaRepository

interface MemberRepository : JpaRepository<Member, Long>{
    fun findByEmail(email: String): Member?
}