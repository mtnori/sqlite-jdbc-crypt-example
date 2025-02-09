plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // JDBC Driver for SQLite3 Multiple Ciphers
    // https://github.com/Willena/sqlite-jdbc-crypt
    implementation("io.github.willena:sqlite-jdbc:3.47.2.0")
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}