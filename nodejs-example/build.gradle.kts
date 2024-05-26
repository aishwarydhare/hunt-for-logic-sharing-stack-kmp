import org.jetbrains.kotlin.gradle.targets.js.dsl.ExperimentalDistributionDsl
import org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootExtension
import org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootPlugin
import org.jetbrains.kotlin.gradle.targets.js.npm.tasks.KotlinNpmInstallTask

plugins {
    kotlin("multiplatform") version "1.9.24"
    // kotlin("multiplatform") version "2.0.0-Beta1"
}

repositories {
    mavenCentral()
}

kotlin {
    js(IR) {
        moduleName = "myModuleName"
        binaries.executable()
        nodejs()
        useCommonJs()
        generateTypeScriptDefinitions()
    }

    sourceSets {
        jsMain.dependencies {
            implementation(npm("algo-visual", "2.1.4"))
            implementation(npm("webpack", "^5.91.0"))
            implementation(npm("webpack-cli", "^5.1.4"))
        }
    }
}

rootProject.the<NodeJsRootExtension>().apply {
    download = false
}

tasks.withType<org.jetbrains.kotlin.gradle.targets.js.npm.tasks.KotlinNpmInstallTask>().configureEach {
    args.add("--ignore-engines")
}

tasks.withType<org.jetbrains.kotlin.gradle.targets.js.ir.KotlinJsIrLink> {
    compilerOptions.moduleKind.set(org.jetbrains.kotlin.gradle.dsl.JsModuleKind.MODULE_COMMONJS)
}

rootProject.the<org.jetbrains.kotlin.gradle.targets.js.yarn.YarnRootExtension>().apply{
    download = false
}
