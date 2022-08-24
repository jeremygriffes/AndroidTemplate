plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
}

java {
    sourceCompatibility = Config.Java.version
    targetCompatibility = Config.Java.version
}

dependencies {
    implementation(project(":core"))

    implementation(Deps.inject)
    implementation(Deps.Ktor.core)
    implementation(Deps.Ktor.logging)
    implementation(Deps.Ktor.serialization)
    implementation(Deps.Ktor.clientSerialization)
    implementation(Deps.Ktor.contentNegotiation)
    implementation(Deps.Ktor.ktorSerialization)
}
