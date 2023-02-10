package com.practice.attendance.domain.attendance

import com.practice.attendance.domain.subject.StudentList
import com.practice.attendance.global.entity.BaseIdEntity
import jakarta.persistence.Entity
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import java.time.LocalDate

@Entity
class AttendanceStatus(
    updateId: Long = 0,
    val participation: Boolean,
    val date: LocalDate,
    @ManyToOne
    @JoinColumn(name = "list_id")
    val studentList: StudentList,
): BaseIdEntity(id = updateId)