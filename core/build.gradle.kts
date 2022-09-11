import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
    id("org.jetbrains.kotlin.plugin.serialization") version "1.7.10"
}

java {
    sourceCompatibility = Config.Java.version
    targetCompatibility = Config.Java.version
}

dependencies {
    implementation(Deps.inject)
    implementation(Deps.serialization)
    implementation(Deps.dateTime)
    implementation(Deps.Coroutines.core)

    testImplementation(Deps.Test.junit)
    testImplementation(Deps.Coroutines.test)
}

tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions.freeCompilerArgs += "-opt-in=kotlin.RequiresOptIn"
}

tasks.withType<Test> {
    useJUnitPlatform()
}
