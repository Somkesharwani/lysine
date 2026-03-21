plugins {
    id("java-library")
    id("java-conventions") // your buildSrc plugin
}

dependencies {
    implementation(platform(springboot.bom))
    api("org.slf4j:slf4j-api")
    // Add Spring Boot starter dependencies as needed
}