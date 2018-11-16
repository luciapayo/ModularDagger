plugins {
    id("com.android.feature")
    id("kotlin-android")
    id("kotlin-android-extensions")
    id("kotlin-kapt")
}

android {
    compileSdkVersion(AndroidVersions.compileSdkVersion)
    baseFeature = true

    defaultConfig {
        minSdkVersion(AndroidVersions.minSdkVersion)
        targetSdkVersion(AndroidVersions.targetSdkVersion)
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("debug") {
            isMinifyEnabled = false
            isDebuggable = true
        }
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {
    // Kotlin
    api(Dependencies.kotlin_stdlib_jdk7)
    api(Dependencies.ktx_core)

    // Dagger2
    api(Dependencies.dagger2)
    kapt(Dependencies.dagger2_compiler)

    // Dagger2 Android
    api(Dependencies.dagger2_android)
    api(Dependencies.dagger2_android_support)
    kapt(Dependencies.dagger2_android_processor)
}
