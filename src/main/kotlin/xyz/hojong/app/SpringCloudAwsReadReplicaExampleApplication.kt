package xyz.hojong.app

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringCloudAwsReadReplicaExampleApplication

fun main(args: Array<String>) {
	runApplication<SpringCloudAwsReadReplicaExampleApplication>(*args)
}
