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
        target("src/*/java/**/*.java")
        targetExclude("**/.gradle/**", "**/build/**", "**/bin/**", "**/generated/**")
        googleJavaFormat("1.17.0")
    }

    kotlin {
        target("src/*/kotlin/**/*.kt")
        targetExclude("**/.gradle/**", "**/build/**", "**/bin/**", "**/generated/**")
        ktlint("0.48.2")
    }

    format("yaml") {
        target("src/*/resources/**/*.yml", "src/*/resources/**/*.yaml")
        targetExclude("**/.gradle/**", "**/build/**", "**/bin/**", "**/generated/**")
        prettier()
    }
}

dependencies {
    // add any dependencies that you want to apply to all your monorepo projects here
}
