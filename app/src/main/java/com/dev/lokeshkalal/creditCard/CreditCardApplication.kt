package com.dev.lokeshkalal.creditCard

import android.app.Application
import com.dev.lokeshkalal.creditCard.di.component.ApplicationComponent
import com.dev.lokeshkalal.creditCard.di.component.DaggerApplicationComponent
import com.dev.lokeshkalal.creditCard.di.module.AppModule
import com.dev.lokeshkalal.creditCard.di.module.ServiceModule

class CreditCardApplication : Application() {


    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        initDagger()
    }

    fun initDagger() {
        applicationComponent = DaggerApplicationComponent.builder()
            .serviceModule(ServiceModule())
            .build()
    }

    fun getAppComponent(): ApplicationComponent {
        return applicationComponent
    }
}