package com.practice.attendance.global.exception.handler

import com.practice.attendance.global.exception.BasicException
import com.practice.attendance.global.exception.ErrorResponse
import gauth.exception.GAuthException
import jakarta.servlet.http.HttpServletRequest
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {
    val log: Logger = LoggerFactory.getLogger(this::class.simpleName)

    @ExceptionHandler(BasicException::class)
    fun basicExceptionHandler(request: HttpServletRequest, ex: BasicException): ResponseEntity<ErrorResponse> {
        log.error(request.requestURI)
        log.error(ex.message)
        val errorResponse = ErrorResponse(ex.errorCode)
        return ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.valueOf(ex.errorCode.code))
    }

    @ExceptionHandler(BindException::class)
    fun bindExceptionHandler(ex: BindException): ResponseEntity<*> {
        val errorMap: MutableMap<String, String?> = HashMap()
        for (error in ex.fieldErrors) {
            errorMap[error.field] = error.defaultMessage
        }
        return ResponseEntity<Map<String, String?>>(errorMap, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(GAuthException::class)
    fun GAuthExceptionHandler(request: HttpServletRequest, ex: GAuthException): ResponseEntity<ErrorResponse>{
        log.error(request.requestURI)
        log.error("{}", ex.code)
        val errorResponse = ErrorResponse(ex.code, "GAuth요청 중 에러 발생")
        return ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.valueOf(ex.code))
    }
}