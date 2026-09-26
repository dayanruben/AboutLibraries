plugins {
    id("com.mikepenz.convention.kotlin-multiplatform")
    id("com.mikepenz.convention.publishing")
    kotlin("plugin.serialization") version baseLibs.versions.kotlin.get()
}

kotlin {
    // Use Kotlin EAP-supported targets instead of convention-plugin defaults
    // that still include retired macOS/iOS x64 and watchOS x86/arm32 targets.
    iosArm64()
    iosSimulatorArm64()
    macosArm64()
    linuxX64()
    linuxArm64()
    mingwX64()
    tvosArm64()
    tvosSimulatorArm64()
    watchosArm64()
    watchosDeviceArm64()
    watchosSimulatorArm64()

    android {
        namespace = "com.mikepenz.aboutlibraries.core"
        lint {
            abortOnError = false
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(libs.kotlinx.serialization)
            }
        }
        val multiplatformMain by creating {
            dependsOn(commonMain)
        }
        val jvmMain by getting {
            dependsOn(multiplatformMain)
        }
        val nativeMain by getting {
            dependsOn(multiplatformMain)
        }
        val jsMain by getting {
            dependsOn(multiplatformMain)
        }
        val androidMain by getting
        val wasmJsMain by getting {
            dependsOn(multiplatformMain)
        }
        val jvmTest by getting {
            dependencies {
                implementation(kotlin("test-junit"))
            }
        }
    }
}