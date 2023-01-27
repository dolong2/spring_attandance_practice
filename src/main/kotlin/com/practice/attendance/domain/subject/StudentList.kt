package com.practice.attendance.domain.subject

import com.practice.attendance.domain.attendance.AttendanceStatus
import com.practice.attendance.domain.member.Member
import com.practice.attendance.global.entity.BaseIdEntity
import jakarta.persistence.*

@Entity
class StudentList(
    @ManyToOne
    @JoinColumn(name = "student_id")
    val student: Member,
    @ManyToOne
    @JoinColumn(name = "subject_id")
    val subject: Subject,
): BaseIdEntity(){
    @OneToMany(cascade = [CascadeType.REMOVE], mappedBy = "studentList")
    val attendanceStatus: List<AttendanceStatus> = mutableListOf()
}