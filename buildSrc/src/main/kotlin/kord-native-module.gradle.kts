import org.apache.tools.ant.taskdefs.condition.Os

plugins {
    org.jetbrains.kotlin.multiplatform
}

kotlin {
    // There are issues with compiling the linux variant on linux
    // Please use WSL if you need to work on the linux port
    if(!Os.isFamily(Os.FAMILY_WINDOWS)) {
        linuxX64()
        // Waiting for Ktor
        // https://youtrack.jetbrains.com/issue/KTOR-6173
        //linuxArm64()
    }

    mingwX64()

    macosArm64()
    macosX64()

    iosArm64()
    iosX64()
    iosSimulatorArm64()

    watchosX64()
    watchosArm64()
    watchosSimulatorArm64()

    tvosX64()
    tvosArm64()
    tvosSimulatorArm64()
}
