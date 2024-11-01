plugins {
    java // for TweetNaclFast
    `kord-module`
    `kord-sampled-module`
    `kord-publishing`
}

dependencies {
    api(projects.common)
    api(projects.gateway)

    implementation(libs.kotlin.logging)
    implementation(libs.slf4j.api)

    implementation(libs.tink)

    compileOnly(projects.kspAnnotations)

    api(libs.ktor.network)
}
