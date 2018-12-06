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
    // Base dependencies
    implementation(project(":base"))
    implementation(project(":graph"))

    // Dagger2
    api(Dependencies.dagger2)
}
