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
    implementation(project(":graph"))

    // Kotlin
    api(Dependencies.kotlin_stdlib_jdk7)
    api(Dependencies.ktx_core)

    // Dagger2
    api(Dependencies.dagger2)
    kapt(Dependencies.dagger2_compiler)

    // AndroidX
    api(Dependencies.app_compat)
}
