package com.dev.lokeshkalal.creditCard.identifier.service

import com.dev.lokeshkalal.creditCard.identifier.*

import javax.inject.Inject
import java.util.ArrayList

class CardIdentifierServiceImpl @Inject
constructor() : CardIdentifierService {

    internal var identifiers: ArrayList<Identifier>

    init {
        identifiers = ArrayList()
        identifiers.add(AmexCardIdentifier())
        identifiers.add(DinerCardIdentifier())
        identifiers.add(MasterCardIdentifier())
        identifiers.add(VisaCardIdentifier())
        identifiers.add(JCBCardIdentifier())
        identifiers.add(MaestroCardIdentifier())
        identifiers.add(DiscoverCardIdentifier())
    }

    override fun identifyCard(cardnumber: String): CardIdentifierResult {
        for (identifier in identifiers) {
            val cardIdentifierResult = identifier.validateCard(cardnumber)
            if (cardIdentifierResult.isValidCard) {
                return cardIdentifierResult
            }
        }

        return CardIdentifierResult.InvalidCard()
    }
}
