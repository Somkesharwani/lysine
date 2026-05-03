plugins {
    id("java-library")

    id("java")
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

    format("yaml") {
        target("**/*.yml", "**/*.yaml")
        prettier()
    }
}

dependencies {
    implementation(platform(springboot.bom))
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.2.0")
    implementation("org.hibernate.orm:hibernate-envers")
    //implementation(project(":user-service"))
    implementation(project(":openApi-service"))
    runtimeOnly("org.postgresql:postgresql")
    api("org.slf4j:slf4j-api")
}