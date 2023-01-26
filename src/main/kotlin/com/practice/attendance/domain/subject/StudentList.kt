package com.practice.attendance.domain.subject

import com.practice.attendance.domain.member.Member
import com.practice.attendance.global.entity.BaseIdEntity
import jakarta.persistence.Entity
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne

@Entity
class StudentList(
    @ManyToOne
    @JoinColumn(name = "student_id")
    val student: Member,
    @ManyToOne
    @JoinColumn(name = "subject_id")
    val subject: Subject,
): BaseIdEntity()