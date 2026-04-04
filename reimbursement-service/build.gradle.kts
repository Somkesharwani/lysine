plugins {
	id("java")
	id("io.freefair.lombok")
	id("com.diffplug.spotless")
	id("org.springframework.boot") version "3.3.2"
	id("io.spring.dependency-management") version "1.1.5"
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
	implementation(project(":openApi-service"))
	implementation(project(":common-lib"))

	implementation(platform(springboot.bom))

	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.2.0")
	implementation("org.hibernate.orm:hibernate-envers")
	implementation("org.mapstruct:mapstruct:1.5.5.Final")
	annotationProcessor("org.mapstruct:mapstruct-processor:1.5.5.Final")

	runtimeOnly("org.postgresql:postgresql")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
}
