rootProject.name = "openApi-service"

pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    versionCatalogs {
        create("springboot") {
            library("bom", "org.springframework.boot:spring-boot-dependencies:3.3.2")
        }
    }
}
