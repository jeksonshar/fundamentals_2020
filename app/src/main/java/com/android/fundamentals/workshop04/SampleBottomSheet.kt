package com.android.fundamentals.workshop04

import android.app.Dialog
import android.content.DialogInterface
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.android.fundamentals.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.snackbar.Snackbar
import kotlin.coroutines.coroutineContext

class SampleBottomSheet : BottomSheetDialogFragment() {

    override fun setupDialog(
        dialog: Dialog,
        style: Int
    ) {
        val contentView =
            View.inflate(context, R.layout.dialog_fragment_ws04, null)

        val cancelButton = contentView.findViewById<Button>(R.id.btn_cancel)
        val okButton = contentView.findViewById<Button>(R.id.btn_ok)

        cancelButton.setOnClickListener {
//            Toast.makeText(context, "Cancel", Toast.LENGTH_LONG).show()
            Snackbar.make(it, "Cancel", Snackbar.LENGTH_INDEFINITE).show()
        }
        okButton.setOnClickListener {
            Toast.makeText(context, "Ok", Toast.LENGTH_LONG).show()
        }

        dialog.setContentView(contentView)
        (contentView.parent as View).setBackgroundColor(
            ContextCompat.getColor(
                contentView.context,
                android.R.color.transparent
            )
        )
    }

    override fun onStop() {
        super.onStop()
//        Toast.makeText(context, "Okно закрыто", Toast.LENGTH_LONG).show()
        view?.let { Snackbar.make(it, "Окно закрыто", Snackbar.LENGTH_INDEFINITE).show() }
    }
}