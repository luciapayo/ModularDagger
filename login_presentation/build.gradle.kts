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
    implementation(project(":architecture_presentation"))

    // Feature dependencies
    implementation(project(":domain_3"))
    implementation(project(":user_session"))

    // This can be removed with proper solution for navigation
    api(project(":home_presentation"))

    // Dagger2
    kapt(Dependencies.dagger2_compiler)
}
