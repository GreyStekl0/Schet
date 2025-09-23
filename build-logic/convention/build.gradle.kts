import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    `kotlin-dsl`
}

group = "dev.steklo.schet.buildlogic"

// Configure the build-logic plugins to target JDK 17
// This matches the JDK used to build the project, and is not related to what is running on device.
java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

kotlin {
    compilerOptions {
        jvmTarget = JvmTarget.JVM_17
    }
}

dependencies {
    compileOnly(libs.android.gradleApiPlugin)
    compileOnly(libs.android.tools.common)
    compileOnly(libs.compose.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
}

tasks {
    validatePlugins {
        enableStricterValidation = true
        failOnWarning = true
    }
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id =
                libs.plugins.schet.android.application
                    .asProvider()
                    .get()
                    .pluginId
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        register("androidApplicationCompose") {
            id =
                libs.plugins.schet.android.application.compose
                    .get()
                    .pluginId
            implementationClass = "AndroidApplicationComposeConventionPlugin"
        }
        register("androidFeature") {
            id =
                libs.plugins.schet.android.feature
                    .get()
                    .pluginId
            implementationClass = "AndroidFeatureConventionPlugin"
        }
        register("androidLibrary") {
            id =
                libs.plugins.schet.android.library
                    .asProvider()
                    .get()
                    .pluginId
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        register("androidLibraryCompose") {
            id =
                libs.plugins.schet.android.library.compose
                    .get()
                    .pluginId
            implementationClass = "AndroidLibraryComposeConventionPlugin"
        }
        register("jvmLibrary") {
            id =
                libs.plugins.schet.jvm.library
                    .get()
                    .pluginId
            implementationClass = "JvmLibraryConventionPlugin"
        }
        register("hilt") {
            id =
                libs.plugins.schet.hilt
                    .get()
                    .pluginId
            implementationClass = "HiltConventionPlugin"
        }
    }
}
