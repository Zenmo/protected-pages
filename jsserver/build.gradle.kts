plugins {
    // Apply the shared build logic from a convention plugin.
    // The shared code is located in `buildSrc/src/main/kotlin/kotlin-jvm.gradle.kts`.
    kotlin("jvm")
    alias(libs.plugins.kotlinPluginSerialization)
    application
}

dependencies {
    implementation("org.graalvm.polyglot:js:24.2.1")
    implementation("org.graalvm.polyglot:polyglot:24.2.1")
    implementation(project(":shared"))
}

application {
    // Define the Fully Qualified Name for the application main class
    // (Note that Kotlin compiles `App.kt` to a class with FQN `com.example.app.AppKt`.)
    mainClass = "energy.lux.protectedpages.app.AppKt"
}
