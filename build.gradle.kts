plugins {
    id("java")
    id("application")
    id("com.diffplug.spotless") version "6.25.0"
}

group = "jon-hoare"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.hamcrest:hamcrest:2.2")
}

tasks.test {
    useJUnitPlatform()
}

application {
    // Set the main class
    mainClass.set("jonhoare.Diamond")
}

spotless {
    java {
        importOrder()
        removeUnusedImports()
        cleanthat()
        googleJavaFormat()
        formatAnnotations()
    }
}