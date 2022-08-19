buildscript {
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://kotlin.bintray.com/kotlinx") }
    }

    dependencies {
        classpath(BuildPlugins.android)
        classpath(BuildPlugins.hilt)
        classpath(BuildPlugins.kotlin)
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.10")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
