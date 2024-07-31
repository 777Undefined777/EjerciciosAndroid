plugins {
    id("com.android.application")
    id("kotlin-android")
    id("com.google.gms.google-services")
}

android {
    compileSdk = 33  // Actualiza a la versión más reciente

    defaultConfig {
        applicationId = "com.example.kotlinprueba"
        minSdk = 21
        targetSdk = 33  // Actualiza a la versión más reciente
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
}

dependencies {
    implementation("androidx.core:core-ktx:1.10.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("com.google.firebase:firebase-auth:22.1.0")
    implementation("com.google.firebase:firebase-database:21.1.1")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}
