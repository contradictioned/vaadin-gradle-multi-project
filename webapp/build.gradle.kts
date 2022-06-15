import com.vaadin.gradle.vaadin

dependencies {
    implementation(project(":common"))
    implementation("com.vaadin:vaadin-spring-boot-starter")
}

plugins {
    id("com.vaadin")
}

vaadin {
    productionMode = true
//    productionMode = false
    pnpmEnable = true
}

val flowCopyFrontendResources = tasks.register<Copy>("flowCopyFrontendResources") {
    from(project(":common").file("src/main/resources/META-INF/resources/frontend/styles"))
    into("$buildDir/flow-frontend/styles")
}

tasks.withType(ProcessResources::class) {
    dependsOn(flowCopyFrontendResources)
}