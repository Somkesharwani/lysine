// buildSrc/src/main/kotlin/java-conventions.gradle.kts

plugins {
    java
    id("io.freefair.lombok")
    id("com.diffplug.spotless")
}

repositories {
    mavenCentral()
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

spotless {
    java {
        target("**/*.java")
        googleJavaFormat("1.17.0")
    }

    kotlin {
        target("**/*.kt")
        ktlint("0.48.2")
    }
}

dependencies {
    // add any dependencies that you want to apply to all your monorepo projects here
}