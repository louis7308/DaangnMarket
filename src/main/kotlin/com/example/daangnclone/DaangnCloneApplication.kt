package com.example.daangnclone

import com.example.daangnclone.domain.post.data.entity.Post
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories

@SpringBootApplication
@EnableJpaAuditing
@EnableRedisRepositories
class DaangnCloneApplication

fun main(args: Array<String>) {
	runApplication<DaangnCloneApplication>(*args)
}
