// @formatter:off
object Deps {
    const val androidKtx = "androidx.core:core-ktx:1.8.0"
    const val inject = "javax.inject:javax.inject:1"
    const val materialDesign = "com.google.android.material:material:1.6.1"
    const val serialization = "org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.3"

    object Hilt {
        const val android = "com.google.dagger:hilt-android:${Versions.hilt}"
        const val compiler = "com.google.dagger:hilt-compiler:${Versions.hilt}"
    }

    object Coroutines {
        const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
        const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
        const val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.4"
    }

    object Androidx {
        const val appCompat = "androidx.appcompat:appcompat:1.4.2"
        const val activityKtx = "androidx.activity:activity-ktx:1.5.0"

        object Lifecycle {
            const val runtime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.androidLifecycle}"
            const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.androidLifecycle}"
            const val common = "androidx.lifecycle:lifecycle-common-java8:${Versions.androidLifecycle}"
            const val compose = "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.androidLifecycle}"
        }

        object Compose {
            const val ui = "androidx.compose.ui:ui:${Versions.composeLib}"
            const val material = "androidx.compose.material:material:${Versions.composeLib}"
            const val preview = "androidx.compose.ui:ui-tooling-preview:${Versions.composeLib}"
            const val activity = "androidx.activity:activity-compose:${Versions.composeLib}"

            const val testUi = "androidx.compose.ui:ui-test-junit4:${Versions.composeLib}"
            const val testTooling = "androidx.compose.ui:ui-tooling:${Versions.composeLib}"
            const val testManifest = "androidx.compose.ui:ui-test-manifest:${Versions.composeLib}"
        }
    }

    object Ktor {
        const val android = "io.ktor:ktor-client-android:${Versions.ktor}"
        const val core = "io.ktor:ktor-client-core:${Versions.ktor}"
        const val clientSerialization = "io.ktor:ktor-client-serialization:${Versions.ktor}"
        const val contentNegotiation = "io.ktor:ktor-client-content-negotiation:${Versions.ktor}"
        const val ktorSerialization = "io.ktor:ktor-serialization-kotlinx-json:${Versions.ktor}"
        const val logging = "io.ktor:ktor-client-logging:${Versions.ktor}"
    }

    object Test {
        const val junit = "junit:junit:4.13.2"
        const val androidJunit = "androidx.test.ext:junit:1.1.3"
        const val espresso = "androidx.test.espresso:espresso-core:3.4.0"
        const val mockk = "io.mockk:mockk:1.9.3"
    }
}
