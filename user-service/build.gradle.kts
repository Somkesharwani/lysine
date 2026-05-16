
plugins {
	id("java")
	id("io.freefair.lombok")
	id("com.diffplug.spotless")
	id("org.springframework.boot") version "3.3.2"
	id("io.spring.dependency-management") version "1.1.5"
	id("org.flywaydb.flyway") version "10.10.0"
}

buildscript {
	repositories {
		mavenCentral()
	}
	dependencies {
		classpath("org.postgresql:postgresql:42.7.3")
	}
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
	implementation(project(":openApi-service"))
	implementation(project(":common-lib"))

	implementation(platform(springboot.bom))

	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.data:spring-data-envers")
	implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.2.0")
	implementation("org.mapstruct:mapstruct:1.5.5.Final")
	implementation("org.hibernate.orm:hibernate-envers")
	implementation("org.openapitools:jackson-databind-nullable:0.2.6")
	annotationProcessor("org.mapstruct:mapstruct-processor:1.5.5.Final")
	implementation("org.springframework.boot:spring-boot-starter-security")
	// Gradle (Kotlin DSL)
	implementation("org.openapitools:jackson-databind-nullable:0.2.6")

	runtimeOnly("org.postgresql:postgresql")
	implementation("org.flywaydb:flyway-core")
	implementation("org.flywaydb:flyway-database-postgresql")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

flyway {
	url = "jdbc:postgresql://localhost:5432/postgres"
	user = "postgres"
	password = "postgres"
	driver = "org.postgresql.Driver"
	schemas = arrayOf("public")
}

subprojects {
	apply(plugin = "java")
	tasks.register("buildAll") {
		dependsOn(subprojects.map { it.tasks.named("build") })
	}
}
