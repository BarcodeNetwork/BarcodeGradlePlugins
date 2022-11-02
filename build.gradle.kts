plugins {
    id("com.gradle.plugin-publish") version "1.0.0"
}

group = "com.vjh0107.barcode"
version = "1.0.0"

subprojects {
    repositories {
        mavenCentral()
        maven("https://jitpack.io")
    }
}

file(rootProject.projectDir.path + "/publish.gradle.kts").let {
    if (it.exists()) {
        apply(it)
        tasks.login {
            val key = extra["GRADLE_PUBLISH_KEY"]?.toString()
            val secret = extra["GRADLE_PUBLISH_SECRET"]?.toString()
            if (key == null || secret == null) {
                throw GradleException("gradlePublishKey 혹은 gradlePublishSecret 이 정의되지 않았습니다.")
            }
            System.setProperty("gradle.publish.key", key)
            System.setProperty("gradle.publish.secret", secret)
            login()
        }
    }
}
