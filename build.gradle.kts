plugins {
    kotlin("multiplatform") version "2.1.20"
    kotlin("plugin.serialization") version "2.1.20"
    `maven-publish`
}

repositories {
    mavenLocal()
    mavenCentral()
}

kotlin {
    js {
        generateTypeScriptDefinitions()
        browser {
            commonWebpackConfig {
                outputFileName = "index.js"
            }
        }
        binaries.executable()
    }

    sourceSets {
        commonMain {}
    }
}

publishing {

}