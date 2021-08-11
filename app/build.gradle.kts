plugins {
    id(Plugins.AndroidApplication)

    kotlin(Kotlin.Plugins.Android)
    kotlin(Kotlin.Plugins.Kapt)
}

android {
    compileSdk = Application.CompileSdk
    defaultConfig {
        applicationId = Application.AndroidPackageName
        minSdk = Application.MinSdk
        targetSdk = Application.TargetSdk
        versionCode = Application.VersionCode
        versionName = Application.VersionName
    }

    buildTypes {
        getByName(Application.Variants.Debug) {
            isDebuggable = true
            isMinifyEnabled = false
            isShrinkResources = false

            resValue("string", "app_name", "${Application.AppName} (Local)")
            addManifestPlaceholders(mapOf("branchIsTest" to true))
        }
        getByName(Application.Variants.Release) {
            isDebuggable = false
            isMinifyEnabled = true
            isShrinkResources = true

            resValue("string", "app_name", Application.AppName)
            addManifestPlaceholders(mapOf("branchIsTest" to false))
        }
    }

    compileOptions {
        isCoreLibraryDesugaringEnabled = true
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    coreLibraryDesugaring(Android.DesugaringLibs)

    implementation(fileTree("libs") { include("*.jar") })

    implementation(Androidx.AppCompat)
    implementation(Androidx.ConstraintLayout)
    implementation(Androidx.CoreKtx)
    implementation(Androidx.LifecycleViewModelKtx)

    implementation(Google.Material)
    implementation(Google.Gson)

    implementation(Koin.Android)
    implementation(Koin.Core)
    implementation(Kotlinx.CoroutinesAndroid)
}