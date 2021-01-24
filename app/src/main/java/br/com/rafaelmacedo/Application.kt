package br.com.rafaelmacedo

import android.app.Application
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.koin.core.context.startKoin

@ExperimentalCoroutinesApi
class Application : Application() {


    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(appModule)
        }
    }
}