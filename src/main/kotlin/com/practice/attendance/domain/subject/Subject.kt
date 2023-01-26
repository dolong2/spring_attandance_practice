package com.practice.attendance.domain.subject

import com.practice.attendance.domain.member.Member
import com.practice.attendance.global.entity.BaseIdEntity
import jakarta.persistence.*

@Entity
class Subject(
    val name: String,
    @OneToOne
    @JoinColumn(name = "teacher_id")
    val teacher: Member,
): BaseIdEntity() {
    @OneToMany(cascade = [CascadeType.REMOVE], mappedBy = "subject")
    val studentList: List<StudentList> = mutableListOf()
}