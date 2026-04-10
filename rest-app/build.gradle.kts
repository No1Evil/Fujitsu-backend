plugins {
    id("java")
    id("org.springframework.boot") version "4.0.4"
    id("io.spring.dependency-management") version "1.1.7"
}

description = "REST API Controller"

dependencies {
    implementation(project(":api:api-protocol"))
    implementation(project(":api:api-domain"))
    implementation(project(":api:api-persistence"))
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:3.0.2")
    implementation("org.springframework.boot:spring-boot-starter-security-oauth2-authorization-server")

    runtimeOnly(project(":implementations:business-logic"))
    runtimeOnly(project(":implementations:persistence-impl"))

    // Better performance xml parser, but a bit harder
    implementation("com.fasterxml.woodstox:woodstox-core:7.1.1")

    implementation("io.jsonwebtoken:jjwt-api:0.13.0")
    runtimeOnly("io.jsonwebtoken:jjwt-impl:0.13.0")
    runtimeOnly("io.jsonwebtoken:jjwt-jackson:0.13.0")

    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-webmvc")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
}