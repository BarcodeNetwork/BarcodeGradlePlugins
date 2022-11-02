plugins {
    `kotlin-dsl`
    `maven-publish`
}

repositories {
    mavenCentral()
}

group = "com.vjh0107.barcode"
version = "1.0.1"

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = "com.vjh0107.barcode"
            artifactId = "buildscripts-common"
            version = project.version.toString()

            from(components["java"])
        }
    }
}
