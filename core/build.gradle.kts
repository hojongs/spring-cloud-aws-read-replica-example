import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    val kotlinVer = "1.6.21"

    id("org.springframework.boot") version "2.6.7"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("jvm") version kotlinVer
    kotlin("plugin.spring") version kotlinVer
    kotlin("plugin.jpa") version kotlinVer
    kotlin("kapt") version kotlinVer
    id("org.jlleitschuh.gradle.ktlint") version "10.2.1"
}

group = "xyz.hojong"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
    mavenCentral()
}

dependencies {
    val springCloudAwsVer = "2.4.1"

    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("io.awspring.cloud:spring-cloud-aws-autoconfigure:$springCloudAwsVer")
    implementation("io.awspring.cloud:spring-cloud-aws-jdbc:$springCloudAwsVer")
    runtimeOnly("org.postgresql:postgresql")
    kapt("org.springframework.boot:spring-boot-configuration-processor")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks {
    withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "17"
        }
    }

    withType<Test> {
        useJUnitPlatform()
    }
}
