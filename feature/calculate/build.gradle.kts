plugins {
    alias(libs.plugins.schet.android.feature)
    alias(libs.plugins.schet.android.library.compose)
}

android {
    namespace = "dev.steklo.schet.feature.calculate"
    testOptions.unitTests.isIncludeAndroidResources = true
}
