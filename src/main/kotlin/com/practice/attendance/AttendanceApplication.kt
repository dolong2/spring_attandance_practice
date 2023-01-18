package com.practice.attendance

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@SpringBootApplication
@ConfigurationPropertiesScan
class AttendanceApplication

fun main(args: Array<String>) {
	runApplication<AttendanceApplication>(*args)
}
