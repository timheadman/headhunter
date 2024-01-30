plugins {
    kotlin("jvm")
    kotlin("plugin.serialization")
}

group = "ru.megaland.kd06.domain"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.5.0")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.2")
    implementation("org.slf4j:slf4j-api:2.0.11")
// https://mvnrepository.com/artifact/io.github.microutils/kotlin-logging
    implementation("io.github.microutils:kotlin-logging:3.0.5")

}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(11)
}