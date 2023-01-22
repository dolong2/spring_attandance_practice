package com.practice.attendance.global.exception

class ErrorResponse(
  errorCode: ErrorCode
) {
    val code: Int = errorCode.code
    val msg: String = errorCode.msg
}