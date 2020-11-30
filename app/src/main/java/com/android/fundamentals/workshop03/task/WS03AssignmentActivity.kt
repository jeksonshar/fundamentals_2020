package com.android.fundamentals.workshop03.task

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.fundamentals.R
import com.android.fundamentals.workshop03.WS03SecondFragment

class WS03AssignmentActivity : AppCompatActivity(), WS03AssignmentFragment.SomeClickListener {

    private val rootFragment = WS03AssignmentFragment()
    private var secondFragment = WS03SecondFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ws02_ws03)

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        fragmentTransaction.apply {
            add(R.id.persistent_container, rootFragment)
            commit()
        }

        if (savedInstanceState == null) {
            secondFragment.apply {
                supportFragmentManager.beginTransaction()
                        .add(R.id.fragments_container, this, SECOND_FRAGMENT_TAG)
                        .commit()
            }
        } else {
            secondFragment = supportFragmentManager.findFragmentByTag(SECOND_FRAGMENT_TAG) as WS03SecondFragment
        }
    }

    override fun increaseValue() {
        secondFragment.increaseValue()
    }

    override fun changeBackground() {
        secondFragment.changeBackground()
    }

    companion object {
        const val SECOND_FRAGMENT_TAG = "SecondFragment"
    }
}