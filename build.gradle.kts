plugins {
    java
    kotlin("jvm") version "1.4-M2"
    `maven-publish`
}

group = "com.leafclient"
version = "1.0.0"

repositories {
    maven("https://dl.bintray.com/kotlin/kotlin-eap")
    mavenCentral()
    mavenLocal()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    api("fr.shyrogan", "Kall", "1.1.0")
    api("fr.shyrogan", "Konfigurate", "1.0.0")
    testCompile("junit", "junit", "4.12")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}
tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}

publishing {
    publications {
        register("mavenJava", MavenPublication::class) {
            from(components["java"])
        }
    }
}