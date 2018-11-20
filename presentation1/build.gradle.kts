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