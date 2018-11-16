object AndroidVersions {
    val compileSdkVersion = 28
    val minSdkVersion = 21
    val targetSdkVersion = 28
}

object Versions {
    val kotlin = "1.3.0"
    val gradle_plugin = "3.4.0-alpha02"
    val appcompat = "1.0.1"
    val ktx_core = "1.0.1"
}

object Dependencies {
    val gradle_plugin = "com.android.tools.build:gradle:${Versions.gradle_plugin}"
    val kotlin_gradle_plugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    val kotlin_stdlib_jdk7 = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    val ktx_core = "androidx.core:core-ktx:${Versions.ktx_core}"
    val app_compat = "androidx.appcompat:appcompat:${Versions.appcompat}"
}