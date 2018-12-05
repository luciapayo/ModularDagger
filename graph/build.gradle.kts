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

    api(Dependencies.kotlin_stdlib_jdk7)

    // Dagger2
    api(Dependencies.dagger2)
    kapt(Dependencies.dagger2_compiler)
}
