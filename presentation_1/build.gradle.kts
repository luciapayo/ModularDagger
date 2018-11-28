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
    api(project(":architecture_presentation"))
    implementation(project(":domain_data_1"))

    // Dagger2
    kapt(Dependencies.dagger2_compiler)

    // Dagger2 Android
    kapt(Dependencies.dagger2_android_processor)
}
