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
    implementation(Deps.Ktor.serialization)
    implementation(Deps.Coroutines.core)

    implementation(Deps.Test.junit)
    implementation(Deps.Test.coroutines)
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    kotlinOptions.freeCompilerArgs += "-opt-in=kotlin.RequiresOptIn"
}
