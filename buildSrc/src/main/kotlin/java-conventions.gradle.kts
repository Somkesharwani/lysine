// buildSrc/src/main/kotlin/java-conventions.gradle.kts

plugins {
    java
    id("io.freefair.lombok") // Note: version is NOT specified here. See Step 7
    // add any other Gradle plugins here
}

repositories {
    mavenCentral()
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

dependencies {
    // add any dependencies that you want to apply to all your monorepo projects here
}