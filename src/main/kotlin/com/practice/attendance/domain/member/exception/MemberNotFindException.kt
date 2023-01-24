package com.practice.attendance.domain.member.exception

import com.practice.attendance.global.exception.BasicException
import com.practice.attendance.global.exception.ErrorCode

class MemberNotFindException: BasicException(ErrorCode.MEMBER_NOT_FIND)