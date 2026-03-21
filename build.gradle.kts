plugins {
    `java-library`
}

val projectVersion: String by project

allprojects {
    apply(plugin = "java")

    group = "global.fujitsu"
    version = projectVersion

    repositories {
        mavenCentral()
    }

    dependencies {
        compileOnly("org.projectlombok:lombok:1.18.44")
        annotationProcessor("org.projectlombok:lombok:1.18.44")

        testCompileOnly("org.projectlombok:lombok:1.18.44")
        testAnnotationProcessor("org.projectlombok:lombok:1.18.44")

        testImplementation(platform("org.junit:junit-bom:5.10.0"))
        testImplementation("org.junit.jupiter:junit-jupiter")
        testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    }

    tasks.withType<Test> {
        useJUnitPlatform {}
    }
}