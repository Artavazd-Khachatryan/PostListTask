package com.task.postlisttask.view.aplication

import android.app.Application
import com.task.postlisttask.di.factoryModule
import com.task.postlisttask.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class BaseApplication: Application(){

    override fun onCreate() {
        super.onCreate()
        createKoin()

    }



    fun createKoin(){
        val koinModuls = listOf(
            viewModelModule,
            factoryModule
        )

        startKoin {
            androidLogger()
            androidContext(this@BaseApplication)
            modules(koinModuls)
        }

    }
}