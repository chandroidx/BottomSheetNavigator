plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    id(libs.plugins.mavenPublish.get().pluginId)
}

android {
    namespace = "com.chandroidx.bottomsheetnavigator"
    compileSdk = 34

    defaultConfig {
        minSdk = 24
        targetSdk = 34
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }

    buildFeatures.compose = true
    composeOptions.kotlinCompilerExtensionVersion = "1.5.12"
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.material)
    implementation(libs.androidx.compose.navigation)
    implementation(libs.androidx.compose.ui)
}

afterEvaluate {
    publishing {
        publications {
            register("release", MavenPublication::class) {
                from(components["release"])

                groupId = "com.github.chandroidx"
                artifactId = "BottomSheetNavigator"
                version = "1.0.4"
            }

            register("debug", MavenPublication::class) {
                from(components["debug"])

                groupId = "com.github.chandroidx"
                artifactId = "BottomSheetNavigator"
                version = "1.0.4"
            }
        }
    }
}
