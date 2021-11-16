import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.5.31"
    application
}

group = "me.rafaelavila"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "13"
}

application {
    mainClass.set("MainKt")
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.1")
    testImplementation("org.assertj:assertj-core:3.21.0")
    testImplementation("io.kotest:kotest-runner-junit5:4.6.3")
    testImplementation("io.kotest:kotest-property-jvm:4.6.3")
}

tasks.withType<Test> {
    useJUnitPlatform {
        include("**/*Properties.class")
        include("**/*Spec.class")
        include("**/*Specs.class")
        include("**/*Test.class")
        include("**/*Tests.class")
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf(
            "-Xjsr305=strict", // Required for strict interpretation of
            "-Xemit-jvm-type-annotations" // Required for annotations on type variables
        )
        jvmTarget = "13" // 1.8 or above
        javaParameters = true // Required to get correct parameter names in reporting
    }
}