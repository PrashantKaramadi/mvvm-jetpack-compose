plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id ("kotlin-kapt") // Optional for certain libraries
}

android {
    namespace = "com.pk.jetpack_compose"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.pk.jetpack_compose"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        compose = true // Enable Jetpack Compose
    }

    composeOptions {
        kotlinCompilerExtensionVersion  = "1.5.3" // Use the latest version here
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.runtime.livedata)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    // Jetpack Compose dependencies
    implementation (libs.androidx.activity.compose) // Use latest version
    implementation (libs.androidx.ui) // Compose UI
    implementation (libs.androidx.material3) // Material 3
    implementation (libs.androidx.ui.tooling.preview) // For Previews
    debugImplementation (libs.androidx.ui.tooling) // For Preview support in Android Studio

    // Optional: If using navigation with Compose
    implementation (libs.androidx.navigation.compose)
    // Retrofit for networking
    implementation (libs.retrofit)
    implementation (libs.converter.gson)

}