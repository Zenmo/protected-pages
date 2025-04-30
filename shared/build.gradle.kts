plugins {
    kotlin("multiplatform")
    alias(libs.plugins.kotlinPluginSerialization)
}

group = "energy.lux.protectedpages.shared"
version = System.getenv("VERSION_TAG") ?: "dev"

kotlin {
    jvm()
    js {
        browser()
    }

    sourceSets {
        commonMain {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.8.0")
            }
        }
    }
}
