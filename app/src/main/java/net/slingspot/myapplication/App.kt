package net.slingspot.myapplication

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import net.slingspot.androidlogger.LogLevel

@HiltAndroidApp
class App : Application() {
    companion object {
        val logLevel = if (BuildConfig.DEBUG) LogLevel.VERBOSE else LogLevel.INFO
    }
}
