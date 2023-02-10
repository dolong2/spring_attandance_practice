package com.practice.attendance.global.entity

import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.MappedSuperclass

@MappedSuperclass
open class BaseIdEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0
)