plugins {
  kotlin("jvm") version "2.0.20"
  application
}

repositories {
  mavenLocal()
  mavenCentral()
}

dependencies {
  testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.3")
  testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.9.3")
  testImplementation("org.junit.jupiter:junit-jupiter-params:5.9.3")
  testRuntimeOnly("org.junit.platform:junit-platform-launcher")
  testImplementation("io.strikt:strikt-core:0.34.1")
  testImplementation("org.hamcrest:hamcrest:2.2")
}

group = "it.twinsbrain.katas"
version = "1"
description = "it.twinsbrain.katas guessing-number"

kotlin {
  jvmToolchain(21)
}

tasks.test {
  useJUnitPlatform()
}
