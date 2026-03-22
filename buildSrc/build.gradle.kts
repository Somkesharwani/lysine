plugins {
    `kotlin-dsl`
}

repositories {
    gradlePluginPortal()
}

kotlin {
    jvmToolchain(21)
}

dependencies {
    // Provide the coordinates for your Gradle plugins here, including their versions
    implementation("io.freefair.gradle:lombok-plugin:8.6")
    // Removed Spring Boot plugin from here
}
