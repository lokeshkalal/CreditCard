package com.dev.lokeshkalal.creditCard.identifier.service;

import com.dev.lokeshkalal.creditCard.Constants;
import com.dev.lokeshkalal.creditCard.CreditCardType;
import com.dev.lokeshkalal.creditCard.identifier.*;

import java.util.ArrayList;

public class CardIdentifierServiceImpl implements CardIdentifierService {

    ArrayList<Identifier> identifiers;

    public CardIdentifierServiceImpl() {
        identifiers = new ArrayList<>();
        identifiers.add(new AmexCardIdentifier());
        identifiers.add(new DinerCardIdentifier());
        identifiers.add(new MasterCardIdentifier());
    }

    @Override
    public CardIdentifierResult identifyCard(String cardnumber) {
        for (Identifier identifier : identifiers) {
            CardIdentifierResult cardIdentifierResult = identifier.validateCard(cardnumber);
            if (cardIdentifierResult.isValidCard()) {
                return cardIdentifierResult;
            }
        }

        return new CardIdentifierResult(CreditCardType.INVALID, Constants.MAX_DEFAULT_CARD_NUMBER, Constants.MAX_DEFAULT_CARD_NUMBER);
    }
}
