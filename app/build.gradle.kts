plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt") // This line enables kapt for Kotlin annotation processing
}


android {
    namespace = "com.example.taskhero2"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.taskhero2"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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

    // Room dependencies
    implementation("androidx.room:room-runtime:2.6.1") // Use the latest version available
    kapt("androidx.room:room-compiler:2.6.1") // Use kapt for Kotlin annotation processing
    implementation("androidx.room:room-ktx:2.6.1") // Kotlin Extensions for Room

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
