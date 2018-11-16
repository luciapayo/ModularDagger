plugins {
    id("com.android.feature")
    id("kotlin-android")
    id("kotlin-android-extensions")
    id("kotlin-kapt")
}

android {
    compileSdkVersion(AndroidVersions.compileSdkVersion)

    defaultConfig {
        minSdkVersion(AndroidVersions.minSdkVersion)
        targetSdkVersion(AndroidVersions.targetSdkVersion)
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {}
    }
}

dependencies {
}
