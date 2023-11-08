plugins {
    id("com.android.application")
}

android {
    namespace = "com.example.daobaokhue_ungdungdocbao"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.daobaokhue_ungdungdocbao"
        minSdk = 29
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
}

dependencies {
    api ("com.android.support:support-annotations:28.0.0")

        implementation("androidx.annotation:annotation:1.7.0")
        // To use the Java-compatible @Experimental API annotation
        implementation("androidx.annotation:annotation-experimental:1.4.0-dev01")

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.annotation:annotation-experimental:1.4.0-dev01")
    implementation("androidx.annotation:annotation:1.7.0")
    testImplementation("junit:junit:4.13.2")
    //implementation("com.android.support:recyclerview-v7:28.1.1")
    implementation("com.squareup.picasso:picasso:2.71828")
    implementation("com.squareup.picasso:picasso:2.5.2")


    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}