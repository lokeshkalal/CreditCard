package com.dev.lokeshkalal.creditCard

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import com.dev.lokeshkalal.creditCard.identifier.service.CardIdentifierServiceImpl
import com.dev.lokeshkalal.creditCard.validator.service.CardValidatorServiceImpl

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import android.view.inputmethod.InputMethodManager
import android.widget.EditText


class MainActivity : AppCompatActivity() {


    val cardTypeToiconMap: HashMap<CreditCardType, Int> = HashMap()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        cardTypeToiconMap.put(
            CreditCardType.DINER,
            R.drawable.card_type_diners_club_international
        )
        cardTypeToiconMap.put(
            CreditCardType.MASTERCARD,
            R.drawable.card_type_mastercard
        )
        cardTypeToiconMap.put(
            CreditCardType.AMERICAN_EXPRESS,
            R.drawable.card_type_amex
        )
        cardTypeToiconMap.put(
            CreditCardType.INVALID,
            R.drawable.card_type_laser
        )
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        credit_card_number.setCardIdentifierService(CardIdentifierServiceImpl())
        credit_card_number.setCardValidatorService(CardValidatorServiceImpl())
        credit_card_number.setBackgroundTextView(card_number_background)

        credit_card_number.setCardIdentifierCallback(object : CardIdentifierCallbacks {
            override fun onCardIdentified(creditCardType: CreditCardType) {
                Log.i("MainActivity", "onCardIdentified " + creditCardType.toString())
                cardTypeToiconMap.get(creditCardType)?.let { card_image_view.setImageResource(it) }
            }

            override fun onNoCardIdentified(errorCode: Int) {
                Log.i("MainActivity", "onNoCardIdentified " + errorCode)
                when (errorCode) {
                    IdentifierErrorResponseCode.DEBIT_CARD ->
                        cardTypeToiconMap.get(CreditCardType.INVALID)?.let { card_image_view.setImageResource(it) }

                    IdentifierErrorResponseCode.NO_CARD_IDENTIFIED ->
                        cardTypeToiconMap.get(CreditCardType.INVALID)?.let { card_image_view.setImageResource(it) }
                }
            }

        })


        credit_card_number.setCardValidatorCallback(object : CardValidatorCallbacks {
            override fun onValidCard(creditCard: CreditCard) {
                Log.i("MainActivity", "onValidCard " + creditCard.toString())
                proceed_button.visibility = View.VISIBLE
            }

            override fun onInvalidCard(errorCode: Int) {
                Log.i("MainActivity", "onInvalidCard " + errorCode)
                proceed_button.visibility = View.GONE

                when (errorCode) {
                    ValidatorErrorResponseCode.INVALID_CARD -> error_tv.text = "something not right"

                    ValidatorErrorResponseCode.INVALID_LENGTH -> error_tv.text = ""
                }
            }

        })

        showKeyboard(credit_card_number)


    }


    fun showKeyboard(editText: EditText) {
        editText.requestFocus()
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(editText, InputMethodManager.SHOW_FORCED)
    }


}
