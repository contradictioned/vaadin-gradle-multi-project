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