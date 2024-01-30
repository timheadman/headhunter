package ru.megaland.headhunter.app

import android.app.Application
import ru.megaland.headhunter.di.AppComponent
import ru.megaland.headhunter.di.DaggerAppComponent

class App : Application() {

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.create()
    }

}