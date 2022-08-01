object Versions {

    // Build Config
    const val COMPILE_SDK = 31
    const val MIN_SDK = 23
    const val TARGET_SDK = 30
    const val VERSION_CODE = 1
    const val VERSION_NAME = "1.0.0"

    // Deps
    const val ANDROID_GRADLE_PLUGIN = "7.1.3"
    const val KOTLIN_VERSION = "1.6.21"
    const val SUPPORT_LIBRARY_ANDROID_X = "1.2.0"
    const val DESIGN = "1.3.0"
    const val NAVIGATION = "2.3.5"
    const val HILT_VERSION = "2.38.1"
    const val HILT_COMPILER = "1.0.0"
    const val HILT_VIEW_MODEL = "1.0.0-alpha03"

    const val JUNIT = "4.12"
    const val JUNIT_EXT = "1.1.2"
    const val ESPRESSO = "3.2.0"
    const val CORE_TESTING = "1.0.0"
    const val ARCH_CORE_TESTING = "2.1.0"
    const val COROUTINE = "1.3.7"
    const val COROUTINE_TEST = "1.6.1"

    const val CONSTRAINT_LAYOUT = "1.1.3"
    const val MOSHI_VERSION = "1.13.0"
    const val MOSHI_CONVERTER = "2.9.0"
    const val RETROFIT = "2.9.0"
    const val OKHTTP = "3.10.0"
    const val MOCKK = "1.12.3"
    const val NAVIGATION_FRAGMENT = "2.3.3"
    const val ANDROID_TEST_RUNNER = "1.1.0"
    const val LIFECYCLE_KTX_VERSION = "2.2.0"
    const val GLIDE = "4.9.0"
    const val INTUIT_SSP = "1.0.6"
    const val PAGING_VERSION = "3.1.0"
}

object Libs {

    // Kotlin
    const val STDLIB = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.KOTLIN_VERSION}"
    const val COROUTINE_CORE =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.COROUTINE}'"

    // Android
    const val APP_COMPAT = "androidx.appcompat:appcompat:${Versions.SUPPORT_LIBRARY_ANDROID_X}"
    const val CONSTRAINT_LAYOUT =
        "androidx.constraintlayout:constraintlayout:${Versions.CONSTRAINT_LAYOUT}"
    const val DESIGN = "com.google.android.material:material:${Versions.DESIGN}"

    const val JUNIT = "junit:junit:${Versions.JUNIT}"
    const val JUNIT_EXT = "androidx.test.ext:junit:${Versions.JUNIT_EXT}"
    const val MOCKK = "io.mockk:mockk:${Versions.MOCKK}"
    const val ESPRESSO_CORE = "androidx.test.espresso:espresso-core:${Versions.ESPRESSO}"
    const val ESPRESSO_CONTRIB = "androidx.test.espresso:espresso-contrib:${Versions.ESPRESSO}"
    const val CORE_TESTING = "androidx.test:core:${Versions.CORE_TESTING}"
    const val ARCH_CORE_TESTING = "androidx.arch.core:core-testing:${Versions.ARCH_CORE_TESTING}"
    const val COROUTINE_TESTING =
        "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.COROUTINE_TEST}"
    const val ANDROID_TEST_RUNNER = "androidx.test:runner:${Versions.ANDROID_TEST_RUNNER}"

    const val MOSHI = "com.squareup.moshi:moshi:${Versions.MOSHI_VERSION}"
    const val MOSHI_CONVERTER = "com.squareup.retrofit2:converter-moshi:${Versions.MOSHI_CONVERTER}"
    const val MOSHI_KOTLIN = "com.squareup.moshi:moshi-kotlin:${Versions.MOSHI_VERSION}"
    const val MOSHI_KOTLIN_CODE_GEN =
        "com.squareup.moshi:moshi-kotlin-codegen:${Versions.MOSHI_VERSION}"
    const val RETROFIT = "com.squareup.retrofit2:retrofit:${Versions.RETROFIT}"

    const val HILT = "com.google.dagger:hilt-android:${Versions.HILT_VERSION}"
    const val HILT_ANDROID = "com.google.dagger:hilt-android-compiler:${Versions.HILT_VERSION}"
    const val HILT_COMPILER = "androidx.hilt:hilt-compiler:${Versions.HILT_COMPILER}"
    const val HILT_ANDROID_COMPILER = "androidx.hilt:hilt-work:${Versions.HILT_COMPILER}"
    const val HILT_VIEW_MODEL = "androidx.hilt:hilt-lifecycle-viewmodel:${Versions.HILT_VIEW_MODEL}"

    const val OKHTTP_LOGGING = "com.squareup.okhttp3:logging-interceptor:${Versions.OKHTTP}"
    const val NAV_FRAGMENT_KTX =
        "androidx.navigation:navigation-fragment-ktx:${Versions.NAVIGATION_FRAGMENT}"
    const val NAV_UI_KTX = "androidx.navigation:navigation-ui-ktx:${Versions.NAVIGATION_FRAGMENT}"
    const val GLIDE = "com.github.bumptech.glide:glide:${Versions.GLIDE}"
    const val GLIDE_COMPILER = "com.github.bumptech.glide:compiler:${Versions.GLIDE}"

    const val SSP = "com.intuit.ssp:ssp-android:${Versions.INTUIT_SSP}"
    const val SDP = "com.intuit.sdp:sdp-android:${Versions.INTUIT_SSP}"

    //Jetpack
    const val LIFECYCLE_VIEWMODEL_KTX =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.LIFECYCLE_KTX_VERSION}"
    const val LIFECYCLE_LIVEDATA_KTX =
        "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.LIFECYCLE_KTX_VERSION}"
    const val LIFECYCLE_EXT =
        "androidx.lifecycle:lifecycle-extensions:${Versions.LIFECYCLE_KTX_VERSION}"
    const val PAGING = "androidx.paging:paging-runtime-ktx:${Versions.PAGING_VERSION}"
}

object Config {
    const val PROD_API_BASE_URL = "https://pixabay.com/"
    const val STAGING_API_BASE_URL =
        "https://pixabay.com/" // Future perspective if we implement Staging Env.
    const val PROD_API_KEY = "12990678-12462fcc2da6261905f9a3a04"
    const val STAGING_API_KEY = "12990678-12462fcc2da6261905f9a3a04"
}
