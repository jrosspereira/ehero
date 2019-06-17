package com.jcore.ehero

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class EheroApplication

fun main(args: Array<String>) {
	runApplication<EheroApplication>(*args)
}
