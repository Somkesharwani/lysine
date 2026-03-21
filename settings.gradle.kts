rootProject.name = "lysine"

include("common-lib")

dependencyResolutionManagement {
    versionCatalogs {
        create("springboot") {
            library("bom", "org.springframework.boot:spring-boot-dependencies:3.3.2")
        }

        create("kafka") {
            library("protobuf.serializer", "io.confluent:kafka-protobuf-serializer:7.6.1")
        }

        create("libs") {
            // Remove invalid placeholders - add real libraries here when needed
            // library("lib1", "group:artifact:version")
            // library("lib2", "group:artifact:version")
        }
    }
}
