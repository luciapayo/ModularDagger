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
    implementation(project(":graph"))
    api(project(":home_presentation"))

    // Dagger2
    kapt(Dependencies.dagger2_compiler)
}
