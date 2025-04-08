plugins {
    kotlin("multiplatform") version "2.1.20"
    kotlin("plugin.serialization") version "2.1.20"
    id("dev.petuska.npm.publish") version "3.5.3"
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
        binaries.library()
    }

    sourceSets {
        commonMain {}
    }
}

publishing {

}

npmPublish {
    version = "0.0.1"
    registries {
        register("npmjs") {
            uri.set("https://registry.npmjs.org")
            authToken.set("<you token>")
        }
    }
}