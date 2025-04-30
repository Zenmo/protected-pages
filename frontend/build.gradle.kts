import org.jetbrains.kotlin.gradle.dsl.JsModuleKind

plugins {
    kotlin("multiplatform")
    // Apply Kotlin Serialization plugin from `gradle/libs.versions.toml`.
    alias(libs.plugins.kotlinPluginSerialization)
}

kotlin {
    compilerOptions {
        compilerOptions.freeCompilerArgs.add("-Xir-per-file")
        compilerOptions.freeCompilerArgs.add("-Xir-minimized-member-names=false")
    }

    js {
        browser()
        binaries.executable()
        useEsModules()
        compilations.all {
            compileTaskProvider.configure {
                compilerOptions.target = "es2015"
                compilerOptions.moduleKind = JsModuleKind.MODULE_ES
            }
        }
    }

    sourceSets {
        jsMain {
            languageSettings.optIn("kotlin.js.ExperimentalJsExport")
            dependencies {
                implementation(project(":shared"))
                implementation("org.jetbrains.kotlin-wrappers:kotlin-js:2025.4.11")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.10.2")
            }
        }
    }
}
