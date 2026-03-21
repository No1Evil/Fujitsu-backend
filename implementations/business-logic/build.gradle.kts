plugins {
    java
    id("org.springframework.boot") version "4.0.3"
    id("io.spring.dependency-management") version "1.1.7"
}

description = "Business logic"

dependencies {
    implementation(project(":api:api-domain"))
    implementation(project(":api:api-persistence"))
    implementation(project(":api:api-protocol"))

    implementation("org.springframework.boot:spring-boot")
    implementation("org.springframework:spring-tx")
}