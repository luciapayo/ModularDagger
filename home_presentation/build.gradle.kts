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

    // User Session
    implementation(project(":user_session"))

    // Dagger2
    kapt(Dependencies.dagger2_compiler)
}
