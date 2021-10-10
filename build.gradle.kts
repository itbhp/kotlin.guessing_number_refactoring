plugins {
  kotlin("jvm") version "1.5.31"
}

repositories {
  mavenLocal()
  mavenCentral()
}

apply(plugin = "kotlin")

dependencies {
  testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
  testImplementation("org.junit.jupiter:junit-jupiter-engine:5.8.1")
  testImplementation("org.junit.jupiter:junit-jupiter-params:5.8.1")
  testImplementation("io.strikt:strikt-core:0.32.0")
  testImplementation("org.hamcrest:hamcrest-all:1.3")
}

group = "it.twinsbrain.katas"
version = "1"
description = "it.twinsbrain.katas guessing-number"
java.sourceCompatibility = JavaVersion.VERSION_11

tasks.test {
  useJUnitPlatform()
}
