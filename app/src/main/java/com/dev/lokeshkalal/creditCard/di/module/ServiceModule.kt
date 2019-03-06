package com.dev.lokeshkalal.creditCard.di.module

import com.dev.lokeshkalal.creditCard.identifier.service.CardIdentifierService
import com.dev.lokeshkalal.creditCard.identifier.service.CardIdentifierServiceImpl
import com.dev.lokeshkalal.creditCard.validator.service.CardValidatorService
import com.dev.lokeshkalal.creditCard.validator.service.CardValidatorServiceImpl
import dagger.Module
import dagger.Provides

@Module
class ServiceModule {

    @Provides
    fun CardIdentifierService(): CardIdentifierService {
        return CardIdentifierServiceImpl()
    }

    @Provides
    fun CardValidatorService(): CardValidatorService {
        return CardValidatorServiceImpl()
    }
}