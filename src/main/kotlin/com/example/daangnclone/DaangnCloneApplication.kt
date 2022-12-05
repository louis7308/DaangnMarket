package com.example.daangnclone

import com.example.daangnclone.global.entity.BaseTimeEntity
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import java.time.LocalDateTime

@SpringBootApplication
@EnableJpaAuditing
class DaangnCloneApplication

fun main(args: Array<String>) {
	val baseTimeEntity = BaseTimeEntity()
	baseTimeEntity.creadtedTime
	runApplication<DaangnCloneApplication>(*args)
}
