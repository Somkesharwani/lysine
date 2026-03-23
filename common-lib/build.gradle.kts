plugins {
    id("java-library")
    id("java-conventions")
}

dependencies {
    implementation(platform(springboot.bom))
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-web")
    api("org.slf4j:slf4j-api")
}