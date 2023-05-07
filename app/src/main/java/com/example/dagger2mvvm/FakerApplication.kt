package com.example.dagger2mvvm

import android.app.Application
import com.example.dagger2mvvm.di.AppComponent
import com.example.dagger2mvvm.di.DaggerAppComponent
import javax.inject.Inject

class FakerApplication : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.factory().create(this)
    }
}