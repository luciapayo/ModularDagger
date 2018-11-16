object AndroidVersions {
    val compileSdkVersion = 28
    val minSdkVersion = 21
    val targetSdkVersion = 28
}

object Versions {
    val kotlin = "1.3.0"
    val gradle_plugin = "3.4.0-alpha02"
}

object Dependencies {
    val gradle_plugin = "com.android.tools.build:gradle:${Versions.gradle_plugin}"
    val kotlin_gradle_plugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
}