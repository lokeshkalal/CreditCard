package com.dev.lokeshkalal.creditCard.identifier.service

import com.dev.lokeshkalal.creditCard.identifier.CardIdentifierResult

interface CardIdentifierService {
    fun identifyCard(cardnumber: String): CardIdentifierResult

}
