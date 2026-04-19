plugins {
    id("org.openapi.generator") version "7.6.0"
    id("java")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(platform(springboot.bom))
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.2.0")
    implementation("org.openapitools:jackson-databind-nullable:0.2.1")
    implementation("org.hibernate.validator:hibernate-validator:8.0.1.Final")

    // For OpenAPI Generator 5.x compatibility (javax.* and swagger-annotations)
    implementation("javax.annotation:javax.annotation-api:1.3.2")
    implementation("javax.validation:validation-api:2.0.1.Final")
    implementation("io.swagger:swagger-annotations:1.6.2")

    // For generated code compatibility (servlet and springfox)
    implementation("javax.servlet:javax.servlet-api:4.0.1")
    implementation("io.springfox:springfox-swagger2:2.9.2")
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
            "dateLibrary" to "java8",
            "useTags" to "true",
            "useBeanValidation" to "true",
            "useDefaultMethod" to "false",
            "delegatePattern" to "true",
            "useSpringBoot3" to "true"
        )
    )
}

// 🔥 auto-generate before compile
sourceSets["main"].java.srcDir("$buildDir/generated/src/main/java")

tasks.compileJava {
    dependsOn(tasks.openApiGenerate)
}