object AndroidVersions {
    val compileSdkVersion = 28
    val minSdkVersion = 21
    val targetSdkVersion = 28
}

object Versions {
    val kotlin = "1.2.71"
    val gradle_plugin = "3.2.1"
    val appcompat = "1.0.1"
    val ktx_core = "1.0.1"
    val dagger2 = "2.19"
    val material = "1.1.0-alpha01"
}

object Dependencies {
    val gradle_plugin = "com.android.tools.build:gradle:${Versions.gradle_plugin}"
    val kotlin_gradle_plugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    val kotlin_stdlib_jdk7 = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    val ktx_core = "androidx.core:core-ktx:${Versions.ktx_core}"
    val app_compat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    val dagger2 = "com.google.dagger:dagger:${Versions.dagger2}"
    val dagger2_compiler = "com.google.dagger:dagger-compiler:${Versions.dagger2}"
    val dagger2_android = "com.google.dagger:dagger-android:${Versions.dagger2}"
    val dagger2_android_support = "com.google.dagger:dagger-android-support:${Versions.dagger2}"
    val dagger2_android_processor = "com.google.dagger:dagger-android-processor:${Versions.dagger2}"
    val material = "com.google.android.material:material:${Versions.material}"
}
