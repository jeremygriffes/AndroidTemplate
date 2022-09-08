plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("dagger.hilt.android.plugin")
    id("kotlin-kapt")
}

android {
    compileSdk = Config.Android.targetSdk

    defaultConfig {
        applicationId = "net.slingspot.myapplication"
        minSdk = Config.Android.minSdk
        targetSdk = Config.Android.targetSdk
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }

    compileOptions {
        sourceCompatibility = Config.Java.version
        targetCompatibility = Config.Java.version
    }

    kotlinOptions {
        jvmTarget = Config.Java.kotlinTarget
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Versions.compose
    }
}

dependencies {

    implementation(Deps.Hilt.android)
    kapt(Deps.Hilt.compiler)

    implementation(project(":core"))
    implementation(project(":network"))
    implementation(project(":androidLogger"))

    implementation(Deps.androidKtx)
    implementation(Deps.materialDesign)
    implementation(Deps.Coroutines.android)
    implementation(Deps.Ktor.android)
    implementation(Deps.Androidx.Compose.ui)
    implementation(Deps.Androidx.Compose.material)
    implementation(Deps.Androidx.Compose.preview)
    implementation(Deps.Androidx.Compose.activity)
    implementation(Deps.Androidx.Lifecycle.viewModel)
    implementation(Deps.Androidx.Lifecycle.common)
    implementation(Deps.Androidx.Lifecycle.runtime)
    implementation(Deps.Androidx.Lifecycle.compose)
    implementation(Deps.Androidx.appCompat)
    implementation(Deps.Androidx.activityKtx)

    testImplementation(Deps.Test.junit)
    androidTestImplementation(Deps.Test.androidJunit)
    androidTestImplementation(Deps.Test.espresso)
    androidTestImplementation(Deps.Androidx.Compose.testUi)
    debugImplementation(Deps.Androidx.Compose.testTooling)
    debugImplementation(Deps.Androidx.Compose.testManifest)
}

kapt {
    correctErrorTypes = true
}
