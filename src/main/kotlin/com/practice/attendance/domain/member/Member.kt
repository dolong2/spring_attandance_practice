package com.practice.attendance.domain.member

import com.practice.attendance.domain.subject.StudentList
import com.practice.attendance.global.entity.BaseIdEntity
import jakarta.persistence.*
import java.util.Collections

@Entity
class Member(
    updateId: Long = 0,
    val email: String,
    val grade: Int,
    val classNum: Int,
    val num: Int,
    val name: String,
    @Enumerated(EnumType.STRING)
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "role", joinColumns = [JoinColumn(name = "id")])
    val roles: MutableList<Role> = Collections.singletonList(Role.ROLE_STUDENT),
): BaseIdEntity(id = updateId){
    @OneToMany(cascade = [CascadeType.REMOVE], mappedBy = "student")
    val studentList: List<StudentList> = mutableListOf()
}