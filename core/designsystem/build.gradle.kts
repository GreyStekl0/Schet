plugins {
    alias(libs.plugins.schet.android.library)
    alias(libs.plugins.schet.android.library.compose)
}

android {
    namespace = "dev.stekl0.schet.core.designsystem"
    testOptions.unitTests.isIncludeAndroidResources = true
}

dependencies {
    api(libs.androidx.compose.material3)
}
