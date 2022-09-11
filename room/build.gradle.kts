// Suppress "Incubating" warnings; remove after switching to a non-canary Android Studio.
@file:Suppress("UnstableApiUsage")

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {
    compileSdk = Config.Android.targetSdk

    defaultConfig {
        minSdk = Config.Android.minSdk
        targetSdk = Config.Android.targetSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = Config.Java.version
        targetCompatibility = Config.Java.version
    }

    kotlinOptions {
        jvmTarget = Config.Java.kotlinTarget
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

dependencies {
    kapt(Deps.Room.compiler)

    implementation(Deps.inject)
    implementation(Deps.dateTime)
    implementation(Deps.serialization)
    implementation(Deps.Hilt.android)
    implementation(Deps.Room.runtime)
    implementation(Deps.Room.ktx)

    testImplementation(Deps.Test.junit)
    testImplementation(Deps.Test.mockk)
}
