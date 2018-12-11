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

    // User Session
    implementation(project(":user_session"))

    implementation(project(":domain_data_1"))
    implementation(project(":domain_data_2"))

    // Dagger2
    kapt(Dependencies.dagger2_compiler)
}
