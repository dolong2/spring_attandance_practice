package com.practice.attendance.global.annotation

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(rollbackFor = [Exception::class])
annotation class TransactionService()
