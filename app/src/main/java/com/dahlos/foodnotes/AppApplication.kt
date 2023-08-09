package com.dahlos.foodnotes

import android.app.Application
import com.dahlos.foodnotes.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext
import org.koin.core.context.startKoin

class AppApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        GlobalContext.startKoin {
            androidContext(this@AppApplication)
            modules(appModule)
        }
    }
}