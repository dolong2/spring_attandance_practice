package com.practice.attendance.global.exception

open class BasicException(
  val errorCode: ErrorCode
) : RuntimeException()