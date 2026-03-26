plugins {
    java
    id("org.springframework.boot") version "4.0.4"
    id("io.spring.dependency-management") version "1.1.7"
}

description = "Business logic"

dependencies {
    implementation(project(":api:api-domain"))
    implementation(project(":api:api-persistence"))
    implementation(project(":api:api-protocol"))

    implementation("org.springframework.boot:spring-boot")
    implementation("org.springframework:spring-tx")

    testImplementation("org.springframework.boot:spring-boot-test-autoconfigure")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.boot:spring-boot-starter-jdbc-test")
    testImplementation(project(":implementations:persistence-impl"))
    testRuntimeOnly(project(":implementations:persistence-impl"))
}