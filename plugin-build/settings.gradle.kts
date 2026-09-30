include(":plugin")

pluginManagement {
    val kotlinVersion = "2.4.21-RC"
    val conventionPluginVersion = "0.11.0"
    resolutionStrategy {
        eachPlugin {
            if (requested.id.id.startsWith("org.jetbrains.kotlin.")) {
                useVersion(kotlinVersion)
            }
            if (requested.id.id.startsWith("com.mikepenz.convention.")) {
                useVersion(conventionPluginVersion)
            }
        }
    }
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
        mavenLocal()
    }
}

dependencyResolutionManagement {
    repositories {
        mavenCentral()
        google()
        gradlePluginPortal()
        mavenLocal()
    }

    versionCatalogs {
        create("libs") {
            from(files("../gradle/libs.versions.toml"))
        }
        create("baseLibs") {
            from("com.mikepenz:version-catalog:0.5.0")
        }
    }
}
