package com.dev.lokeshkalal.creditCard.identifier.service;

import com.dev.lokeshkalal.creditCard.identifier.CardIdentifierResult;

public interface CardIdentifierService {
    CardIdentifierResult identifyCard(String cardnumber);

}
