pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
    }
    plugins {
        id("io.freefair.lombok") version "8.6"
        id("com.diffplug.spotless") version "6.22.0"
    }
}

dependencyResolutionManagement {
    versionCatalogs {
        create("springboot") {
            library("bom", "org.springframework.boot:spring-boot-dependencies:3.3.2")
        }
    }
}

rootProject.name = "user-service"
