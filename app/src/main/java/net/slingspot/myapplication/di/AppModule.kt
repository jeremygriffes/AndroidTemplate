package net.slingspot.myapplication.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.ktor.client.engine.*
import io.ktor.client.engine.android.*
import net.slingspot.androidlogger.LogcatLogger
import net.slingspot.core.log.Logger
import net.slingspot.myapplication.App
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Singleton
    @Provides
    fun app(@ApplicationContext context: Context): App = context as App

    @Provides
    @Singleton
    fun logger(): Logger = LogcatLogger(App.logLevel)

    @Provides
    @Singleton
    fun httpClientEngine(): HttpClientEngine = Android.create()
}
