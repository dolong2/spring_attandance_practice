package com.practice.attendance.global.exception

enum class ErrorCode(
    val code: Int,
    val msg: String,
) {
    BAD_REQUEST(400, "잘못된 요청입니다."),

    UNAUTHORIZED(401, "권한이 없습니다."),
    TOKEN_EXPIRED(401, "토큰이 만료되었습니다."),
    TOKEN_INVALID(401, "토큰이 변질되었습니다."),

    FORBIDDEN(403, "금지된 요청입니다."),

    NOT_FOUND(404, "리소스를 찾을 수 없습니다."),

    INTERNAL_ERROR(500, "서버 내부 에러"),
}