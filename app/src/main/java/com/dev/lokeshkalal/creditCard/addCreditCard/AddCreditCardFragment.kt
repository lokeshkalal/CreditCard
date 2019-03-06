package com.dev.lokeshkalal.creditCard.addCreditCard

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dev.lokeshkalal.creditCard.CreditCardApplication
import com.dev.lokeshkalal.creditCard.R
import com.dev.lokeshkalal.creditCard.identifier.service.CardIdentifierService
import com.dev.lokeshkalal.creditCard.common.showKeyboard
import com.dev.lokeshkalal.creditCard.validator.service.CardValidatorService
import kotlinx.android.synthetic.main.add_card_layout.*
import javax.inject.Inject


class AddCreditCardFragment : Fragment() {

    val cardTypeToiconMap: HashMap<CreditCardType, Int> = HashMap()

    @Inject
    lateinit var cardValidatorService: CardValidatorService
    @Inject
    lateinit var cardIdentifierService: CardIdentifierService

    init {
        initCardTypeToIconMap()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.let { (it.application as CreditCardApplication).getAppComponent().inject(this) }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_credit_card, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initCardNumberView()
        credit_card_number.showKeyboard()
        cardTypeToiconMap.get(CreditCardType.INVALID)?.let { card_image_view.setImageResource(it) }
    }

    private fun initCardNumberView() {
        credit_card_number.setCardIdentifierService(cardIdentifierService)
        credit_card_number.setCardValidatorService(cardValidatorService)
        credit_card_number.setBackgroundTextView(card_number_background)
        credit_card_number.setCardIdentifierCallback(cardIdentifierCallbacks)
        credit_card_number.setCardValidatorCallback(cardValidatorCallbacks)
    }

    val cardIdentifierCallbacks = object : CardIdentifierCallbacks {
        override fun onCardIdentified(creditCardType: CreditCardType) {
            Log.i(AddCreditCardFragment.FRAGMENT_TAG, "onCardIdentified " + creditCardType.toString())
            cardTypeToiconMap.get(creditCardType)?.let { card_image_view.setImageResource(it) }
        }

        override fun onNoCardIdentified(errorCode: Int) {
            Log.i(AddCreditCardFragment.FRAGMENT_TAG, "onNoCardIdentified " + errorCode)
            when (errorCode) {
                IdentifierErrorResponseCode.DEBIT_CARD ->
                    cardTypeToiconMap.get(CreditCardType.INVALID)?.let { card_image_view.setImageResource(it) }

                IdentifierErrorResponseCode.NO_CARD_IDENTIFIED ->
                    cardTypeToiconMap.get(CreditCardType.INVALID)?.let { card_image_view.setImageResource(it) }
            }
        }

    }

    val cardValidatorCallbacks = object : CardValidatorCallbacks {
        override fun onValidCard(creditCard: CreditCard) {
            Log.i(AddCreditCardFragment.FRAGMENT_TAG, "onValidCard " + creditCard.toString())
            proceed_button.visibility = View.VISIBLE
        }

        override fun onInvalidCard(errorCode: Int) {
            Log.i(AddCreditCardFragment.FRAGMENT_TAG, "onInvalidCard " + errorCode)
            proceed_button.visibility = View.GONE

            when (errorCode) {
                ValidatorErrorResponseCode.INVALID_CARD -> error_tv.text = "something not right"

                ValidatorErrorResponseCode.INVALID_LENGTH -> error_tv.text = ""
            }
        }

    }

    private fun initCardTypeToIconMap() {
        cardTypeToiconMap.apply {
            put(
                CreditCardType.DINER,
                R.drawable.card_type_diners_club_international
            )
            put(
                CreditCardType.MASTERCARD,
                R.drawable.card_type_mastercard
            )
            put(
                CreditCardType.AMERICAN_EXPRESS,
                R.drawable.card_type_amex
            )

            put(
                CreditCardType.VISA,
                R.drawable.card_type_visa
            )
            put(
                CreditCardType.DISCOVER,
                R.drawable.card_type_discover
            )
            put(
                CreditCardType.JCB,
                R.drawable.card_type_jcb
            )
            put(
                CreditCardType.MAESTRO,
                R.drawable.card_type_maestro
            )

            put(
                CreditCardType.INVALID,
                R.drawable.card_type_invalid
            )
        }
    }

    companion object {
        val FRAGMENT_TAG = "AddCreditCardFragment"

        @JvmStatic
        fun newInstance() = AddCreditCardFragment()

    }
}
