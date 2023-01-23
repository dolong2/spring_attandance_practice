package com.practice.attendance.global.config.security

import com.fasterxml.jackson.databind.ObjectMapper
import com.practice.attendance.global.exception.ErrorCode
import com.practice.attendance.global.exception.ErrorResponse
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.MediaType
import org.springframework.security.core.AuthenticationException
import org.springframework.security.web.AuthenticationEntryPoint
import org.springframework.stereotype.Component

@Component
class CustomAuthenticationEntryPoint(
    private val objectMapper: ObjectMapper
): AuthenticationEntryPoint {

    override fun commence(
        request: HttpServletRequest,
        response: HttpServletResponse,
        authException: AuthenticationException
    ) {
        val errorCode = ErrorCode.UNAUTHORIZED
        val responseString = objectMapper.writeValueAsString(ErrorResponse(errorCode))
        response.characterEncoding = "UTF-8"
        response.status = errorCode.code
        response.contentType = MediaType.APPLICATION_JSON_VALUE
        response.writer.write(responseString)
    }
}