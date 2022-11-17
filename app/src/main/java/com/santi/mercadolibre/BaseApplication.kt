package com.santi.mercadolibre

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

//AndroidApp para reconocimiento de Hilt - Dagger
@HiltAndroidApp
class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
    }
}