buildscript {
    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath(Dependencies.gradle_plugin)
        classpath(Dependencies.kotlin_gradle_plugin)
    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
