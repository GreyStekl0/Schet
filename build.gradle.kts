import com.deezer.caupain.model.StabilityLevelPolicy
import com.deezer.caupain.plugin.DependenciesUpdateTask

// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false
    alias(libs.plugins.ksp) apply false
    alias(libs.plugins.caupain) apply true
}

tasks.withType<DependenciesUpdateTask> {
    selectIf(StabilityLevelPolicy)
}
