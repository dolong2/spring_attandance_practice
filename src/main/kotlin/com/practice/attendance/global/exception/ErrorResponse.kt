package com.practice.attendance.global.exception

class ErrorResponse(
    val code: Int,
    val msg: String
) {
    constructor(errorCode: ErrorCode): this(errorCode.code, errorCode.msg)
}