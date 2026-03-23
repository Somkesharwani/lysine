
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

	runtimeOnly("org.postgresql:postgresql")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

subprojects {
    apply(plugin = "java")
    tasks.register("buildAll") {
        dependsOn(subprojects.map { it.tasks.named("build") })
    }
}