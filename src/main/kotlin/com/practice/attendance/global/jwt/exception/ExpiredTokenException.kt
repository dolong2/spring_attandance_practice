package com.practice.attendance.global.jwt.exception

import com.practice.attendance.global.exception.BasicException
import com.practice.attendance.global.exception.ErrorCode

class ExpiredTokenException : BasicException(ErrorCode.TOKEN_EXPIRED)