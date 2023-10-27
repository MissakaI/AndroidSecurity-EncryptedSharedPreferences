package com.example.androidsecurity.di
import android.app.Application
import android.content.Context
import com.example.androidsecurity.utils.KeyStoreHelper
import com.example.androidsecurity.utils.SharedPreferenceHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

/**
 * This is the Dagger Hilt module that provides the dependencies for the app.
 * [AppModule] provides the app level dependencies
 */
@InstallIn(SingletonComponent::class)
@Module
class AppModule {

    /**
     * Provides the application context
     */
    @Provides
    @Singleton
    fun provideContext(application: Application): Context {
        return application.applicationContext
    }

    /**
     * Provides the [SharedPreferenceHelper] instance
     */
    @Provides
    @Singleton
    fun provideSharedPreferencesHelper(context: Context): SharedPreferenceHelper {
        return SharedPreferenceHelper.getInstance(context)
    }

    /**
     * Provides the [KeyStoreHelper] instance
     */
    @Provides
    @Singleton
    fun provideKeyStoreHelper(): KeyStoreHelper {
        return KeyStoreHelper.getInstance()
    }

    @Provides
    @Singleton
    fun provideCoroutineDispatcher(): CoroutineDispatcher = Dispatchers.Default
}