import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.0"
    id("org.springframework.boot") version "2.6.8" apply false
    id("com.vaadin") version "23.1.0" apply false
}

allprojects {
    repositories {
        mavenCentral()
        maven { setUrl("https://maven.vaadin.com/vaadin-prereleases") }
        maven { setUrl("https://maven.vaadin.com/vaadin-addons") }
    }

    group = "org.example"
    version = "1.0-SNAPSHOT"
}

subprojects {
    apply(plugin = "kotlin")

    apply(plugin = "io.spring.dependency-management")
    configure<io.spring.gradle.dependencymanagement.dsl.DependencyManagementExtension> {
        imports {
            mavenBom(org.springframework.boot.gradle.plugin.SpringBootPlugin.BOM_COORDINATES)
            mavenBom("com.vaadin:vaadin-bom:23.1.0")
        }
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}