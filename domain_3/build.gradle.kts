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
    implementation(project(":graph"))

    api(project(":domain_data_1"))
    api(project(":legacy"))

    // Dagger2
    kapt(Dependencies.dagger2_compiler)
}
