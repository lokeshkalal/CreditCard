package com.dev.lokeshkalal.creditcard.identifier.service

import com.dev.lokeshkalal.creditCard.addCreditCard.CreditCardType
import com.dev.lokeshkalal.creditCard.identifier.service.CardIdentifierService
import com.dev.lokeshkalal.creditCard.identifier.service.CardIdentifierServiceImpl
import com.dev.lokeshkalal.creditCard.validator.luhnsValidator.LuhnsValidator
import org.junit.Assert.*
import org.junit.Test

class CardIdentifierServiceImplTest{



    @Test
    fun testVisaCard() {
        val cardIdentifierService: CardIdentifierService = CardIdentifierServiceImpl()
        assertEquals(cardIdentifierService.identifyCard("4555666").cardType,CreditCardType.VISA)
    }

    @Test
    fun testAmexCard() {
        val cardIdentifierService: CardIdentifierService = CardIdentifierServiceImpl()
        assertEquals(cardIdentifierService.identifyCard("37599595").cardType,CreditCardType.AMERICAN_EXPRESS)
    }


    @Test
    fun testInvalidCard() {
        val cardIdentifierService: CardIdentifierService = CardIdentifierServiceImpl()
        assertEquals(cardIdentifierService.identifyCard("0037599595").cardType,CreditCardType.INVALID)
    }
}