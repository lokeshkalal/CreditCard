package com.dev.lokeshkalal.creditCard.addCreditCard

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.transaction
import com.dev.lokeshkalal.creditCard.*

import kotlinx.android.synthetic.main.activity_main.*


class AddCreditCardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        showAddCreditCardFragment()
    }

    private fun showAddCreditCardFragment() {
        supportFragmentManager.transaction(now = false, allowStateLoss = false) {
            replace(
                R.id.container,
                AddCreditCardFragment.Companion.newInstance(),
                AddCreditCardFragment.Companion.FRAGMENT_TAG
            )
        }
    }

}
