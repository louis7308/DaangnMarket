package com.example.daangnclone

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@SpringBootApplication
@EnableJpaAuditing
class DaangnCloneApplication

fun main(args: Array<String>) {
	runApplication<DaangnCloneApplication>(*args)
}
