import com.android.build.gradle.ProguardFiles.getDefaultProguardFile
import org.gradle.internal.impldep.com.amazonaws.PredefinedClientConfigurations.defaultConfig
import org.jetbrains.kotlin.config.KotlinCompilerVersion
import org.jetbrains.kotlin.kapt3.base.Kapt.kapt

plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-android-extensions")
    id("kotlin-kapt")
}

android {
    compileSdkVersion(AndroidVersions.compileSdkVersion)
    defaultConfig {
        applicationId = "com.n26.modulardagger"
        minSdkVersion(AndroidVersions.minSdkVersion)
        targetSdkVersion(AndroidVersions.targetSdkVersion)
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("debug") {}
    }
}

dependencies {

    implementation(project(":base"))

    // AndroidX
    implementation(Dependencies.app_compat)

    // Dagger2
    kapt(Dependencies.dagger2_compiler)

    // Dagger2 Android
    implementation(Dependencies.dagger2_android)
    implementation(Dependencies.dagger2_android_support)
    kapt(Dependencies.dagger2_android_processor)
}
