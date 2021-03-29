import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.31"
    application
    id("org.openjfx.javafxplugin") version "0.0.9"
    id("org.beryx.jlink") version "2.23.5"
}

val compileKotlin: KotlinCompile by tasks
val compileJava: JavaCompile by tasks
compileJava.destinationDir = compileKotlin.destinationDir

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(16))
    }
}

application {
    mainModule.set("test.kotlin")
    mainClass.set("org.beryx.jlink.test.kotlin.JavaFX")
}

repositories {
    mavenCentral()
}

javafx {
    modules = listOf("javafx.controls", "javafx.fxml", "javafx.web")
}

jlink{
    launcher {
        name = "hello"
    }
    imageZip.set(project.file("${project.buildDir}/image-zip/hello-image.zip"))
}
