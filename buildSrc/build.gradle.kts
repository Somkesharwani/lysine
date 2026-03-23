plugins {
    `kotlin-dsl`
}

repositories {
    gradlePluginPortal()
}

dependencies {
    // Provide the coordinates for your Gradle plugins here, including their versions
    implementation("io.freefair.gradle:lombok-plugin:8.6")
    implementation("com.diffplug.spotless:spotless-plugin-gradle:6.22.0")
    // Removed Spring Boot plugin from here
}