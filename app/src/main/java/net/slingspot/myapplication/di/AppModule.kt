package net.slingspot.myapplication.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.ktor.client.engine.*
import io.ktor.client.engine.android.*
import net.slingspot.androidlogger.LogLevel.VERBOSE
import net.slingspot.androidlogger.LogcatLogger
import net.slingspot.core.Logger
import net.slingspot.core.NetworkApi
import net.slingspot.core.Repository
import net.slingspot.myapplication.App
import net.slingspot.network.NetworkKtor
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Singleton
    @Provides
    fun app(@ApplicationContext context: Context): App = context as App

    @Provides
    @Singleton
    fun network(ktor: NetworkKtor): NetworkApi = ktor

    @Provides
    @Singleton
    fun repository(repo: Repository.Default): Repository = repo

    @Provides
    @Singleton
    fun logger(): Logger = LogcatLogger(VERBOSE)

    @Provides
    @Singleton
    fun httpClientEngine(): HttpClientEngine = Android.create()
}
