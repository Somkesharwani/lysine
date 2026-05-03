
plugins {
	id("java-conventions")
	id("org.springframework.boot") version "3.3.2"
	id("io.spring.dependency-management") version "1.1.5"
}

dependencies {
	implementation(project(":openApi-service"))
	implementation(project(":common-lib"))

	implementation(platform(springboot.bom))

	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.2.0")
	implementation("org.mapstruct:mapstruct:1.5.5.Final")
	implementation("org.hibernate.orm:hibernate-envers")
	implementation("org.openapitools:jackson-databind-nullable:0.2.6")
	annotationProcessor("org.mapstruct:mapstruct-processor:1.5.5.Final")
	implementation("org.springframework.boot:spring-boot-starter-security")
	// Gradle (Kotlin DSL)
	implementation("org.openapitools:jackson-databind-nullable:0.2.6")

	runtimeOnly("org.postgresql:postgresql")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

subprojects {
	apply(plugin = "java")
	tasks.register("buildAll") {
		dependsOn(subprojects.map { it.tasks.named("build") })
	}
}