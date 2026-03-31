plugins {
    `kotlin-dsl`
}

repositories {
    gradlePluginPortal()
    mavenCentral()
}

dependencies {
    // Provide the coordinates for your Gradle plugins here, including their versions
    implementation("io.freefair.gradle:lombok-plugin:8.6")
    implementation("com.diffplug.spotless:spotless-plugin-gradle:6.22.0")
    implementation("org.hibernate.orm:hibernate-envers:6.4.4.Final")
    // Removed Spring Boot plugin from here
}