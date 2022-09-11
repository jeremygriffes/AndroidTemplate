pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}

rootProject.name = "MyApplication"

include(
    ":app",
    ":core",
    ":network",
    ":androidLogger",
    ":room",
)
