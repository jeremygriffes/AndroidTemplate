pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}

rootProject.name = "My Application"

include(
    ":app",
    ":core",
    ":network",
    ":androidLogger",
)
