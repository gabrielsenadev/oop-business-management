plugins {
    id("java")
    application
}
application {
    mainClass = "dev.gabrielsena.Main"
}

group = "dev.gabrielsena"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}

tasks.jar {
    manifest.attributes(mapOf(Pair("Main-Class", "dev.gabrielsena.Main")))
}
