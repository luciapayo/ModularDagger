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
        getByName("debug") {
            isMinifyEnabled = false
            isDebuggable = true
        }
    }
}

dependencies {
    // Base dependencies
    implementation(project(":base"))
    implementation(project(":graph"))

    // This can be removed with proper solution for navigation
    implementation(project(":login_presentation"))

    // AndroidX
    implementation(Dependencies.app_compat)

    // Dagger2
    kapt(Dependencies.dagger2_compiler)
}
