plugins {
    id("java")
}

description = "Business service interfaces"

dependencies {
    implementation(project(":api:api-protocol"))
}