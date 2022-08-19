import org.gradle.api.JavaVersion

object Config {
    object Android {
        const val minSdk = 23
        const val targetSdk = 32
    }

    object Java {
        val version = JavaVersion.VERSION_1_8
        const val kotlinTarget = "1.8"
    }
}
