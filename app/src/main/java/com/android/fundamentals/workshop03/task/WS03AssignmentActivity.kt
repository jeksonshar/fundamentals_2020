package com.android.fundamentals.workshop03.task

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.android.fundamentals.R
import com.android.fundamentals.workshop03.WS03SecondFragment

//TODO(WS2:9) Implement interface in Activity
class WS03AssignmentActivity : AppCompatActivity(), WS03AssignmentFragment.SomeClickListener {

    //TODO(WS2:9) Create root fragment and set listener
    private val rootFragment = WS03AssignmentFragment().apply { setListener(this@WS03AssignmentActivity) }
    private var secondFragment = WS03SecondFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ws02_ws03)

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        fragmentTransaction.apply {
            //TODO(WS2:3) Add the Fragment to the R.id.persistent_container FrameLayout
            add(R.id.persistent_container, rootFragment)
            commit()
        }

        if (savedInstanceState == null) {
            secondFragment.apply {
                supportFragmentManager.beginTransaction()
                        .replace(R.id.fragments_container, this, SECOND_FRAGMENT_TAG)
                        .commit()
            }
        } else {
            secondFragment = supportFragmentManager.findFragmentByTag(SECOND_FRAGMENT_TAG) as WS03SecondFragment
            secondFragment.count = savedInstanceState.getInt(KEY_COUNT)

            val backgroundSavedEnum = savedInstanceState.getString(KEY_BACKGROUND_ENUM)
            if (backgroundSavedEnum != null) {
                secondFragment.backgroundColor = WS03SecondFragment.BackgroundColor
                        .valueOf(backgroundSavedEnum)
            }

            secondFragment.tvValue?.apply {
                background = ContextCompat.getDrawable(baseContext, secondFragment.backgroundColor.resId)
            }
//            val backgroundSavedEnum = savedInstanceState.getString(KEY_BACKGROUND_ENUM)
//            if (backgroundSavedEnum != null) {
//                secondFragment.restoreBackground(backgroundSavedEnum)
//            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putInt(KEY_COUNT, secondFragment.count)
        outState.putInt(KEY_BACKGROUND_ID, secondFragment.backgroundColor.resId)
        outState.putString(KEY_BACKGROUND_ENUM, secondFragment.backgroundColor.name)
    }

    //TODO(WS2:10) Change the text in secondFragment
    override fun increaseValue() {
        secondFragment.increaseValue()
    }

    //TODO(WS2:11) Change fragment text background in secondFragment
    override fun changeBackground() {
        secondFragment.changeBackground()
    }

    companion object {
        const val SECOND_FRAGMENT_TAG = "SecondFragment"
        const val KEY_COUNT = "KeyCount"
        const val KEY_BACKGROUND_ID = "KeyBackgroundId"
        const val KEY_BACKGROUND_ENUM = "KeyBackgroundEnum"
    }
}