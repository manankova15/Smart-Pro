import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.6.10"  // Версия Kotlin
    id("org.springframework.boot") version "2.7.0"  // Версия Spring Boot
    id("io.spring.dependency-management") version "1.0.11.RELEASE"  // Управление зависимостями
}

group = "com.example"  // Группа проекта
version = "1.0-SNAPSHOT"  // Версия проекта
java.sourceCompatibility = JavaVersion.VERSION_17  // Версия Java

repositories {
    mavenCentral()  // Репозиторий Maven Central
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-webflux")  // Зависимости Spring Boot
    implementation("org.springframework.boot:spring-boot-starter-data-mongodb-reactive")  // Зависимость для работы с MongoDB Reactive
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")  // Зависимость для работы с JPA (если нужно)
    implementation("org.jetbrains.kotlin:kotlin-reflect")  // Рефлексия Kotlin
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")  // Стандартная библиотека Kotlin для JDK 8

    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")  // Модуль Jackson для Kotlin

    // Дополнительные зависимости по необходимости (например, для тестирования, безопасности и т.д.)
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = "17"  // Версия JVM для компиляции
    }
}

// Задача для сборки JAR/WAR файла
tasks.build {
    dependsOn("clean")
    dependsOn("bootJar")  // Используйте bootWar, если вам нужен WAR файл
}
