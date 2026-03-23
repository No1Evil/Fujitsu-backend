plugins {
    java
    id("org.springframework.boot") version "4.0.3"
    id("io.spring.dependency-management") version "1.1.7"
}

description = "H2 database implementation of api-persistence"

dependencies {
    implementation(project(":api:api-persistence"))
    implementation(project(":api:api-protocol"))

    implementation("org.springframework.boot:spring-boot")
    implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
    runtimeOnly("com.h2database:h2")
}