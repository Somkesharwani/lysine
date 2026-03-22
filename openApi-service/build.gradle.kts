plugins {
    id("java")
    id("org.openapi.generator") version "7.6.0"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(platform(springboot.bom))
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.2.0")
    implementation("org.openapitools:jackson-databind-nullable:0.2.1")
    implementation("io.swagger.core.v3:swagger-annotations:2.2.17")
    implementation("jakarta.validation:jakarta.validation-api:3.0.2")
}

openApiGenerate {
    generatorName.set("spring")
    inputSpec.set("$projectDir/src/main/resources/openApi.yaml")
    outputDir.set("$buildDir/generated")

    apiPackage.set("com.lysine.api")
    modelPackage.set("com.lysine.model")

    configOptions.set(
        mapOf(
            "interfaceOnly" to "true",
            "useSpringBoot3" to "true",
            "dateLibrary" to "java8"
        )
    )
}

// 🔥 auto-generate before compile
sourceSets["main"].java.srcDir("$buildDir/generated/src/main/java")

tasks.compileJava {
    dependsOn(tasks.openApiGenerate)
}