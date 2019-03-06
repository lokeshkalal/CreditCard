package com.dev.lokeshkalal.creditCard.di.component

import com.dev.lokeshkalal.creditCard.addCreditCard.AddCreditCardActivity
import com.dev.lokeshkalal.creditCard.addCreditCard.AddCreditCardFragment
import com.dev.lokeshkalal.creditCard.di.module.AppModule
import com.dev.lokeshkalal.creditCard.di.module.ServiceModule
import dagger.Component


@Component(modules = arrayOf(ServiceModule::class, AppModule::class))
interface ApplicationComponent {

    fun inject(addCreditCardActivity: AddCreditCardActivity)
    fun inject(addCreditCardFragment: AddCreditCardFragment)
}
