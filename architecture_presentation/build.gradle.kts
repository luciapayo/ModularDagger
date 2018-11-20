plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-android-extensions")
    id("kotlin-kapt")
}

android {
    compileSdkVersion(AndroidVersions.compileSdkVersion)
}

dependencies {
    // AndroidX
    api(Dependencies.app_compat)

    // Dagger2 Android
    api(Dependencies.dagger2_android)
    api(Dependencies.dagger2_android_support)
    kapt(Dependencies.dagger2_android_processor)
}
