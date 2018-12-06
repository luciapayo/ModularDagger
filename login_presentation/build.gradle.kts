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
    // Base Dependencies
    implementation(project(":base"))
    implementation(project(":graph"))

    // Feature dependencies
    implementation(project(":domain_data_1"))
    api(project(":home_presentation"))

    // Dagger2
    kapt(Dependencies.dagger2_compiler)
}
