package com.android.fundamentals.workshop04.task

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.android.fundamentals.R

class WS04AssignmentDialogFragment : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.dialog_fragment_ws04, container, false)

        val buttonCancel: Button = view.findViewById(R.id.btn_cancel)
        val buttonOk = view.findViewById<Button>(R.id.btn_ok)

        buttonCancel.setOnClickListener {
            Toast.makeText(context, "Cancel", Toast.LENGTH_LONG).show()
        }
        buttonOk.setOnClickListener {
            Toast.makeText(context, "Ok", Toast.LENGTH_LONG).show()
        }
        return view
    }

    override fun onStart() {
        super.onStart()
        val width = (resources.displayMetrics.widthPixels * 0.85).toInt()
        val height = (resources.displayMetrics.heightPixels * 0.40).toInt()
        dialog?.window?.setLayout(width, height)
    }

    override fun onStop() {
        super.onStop()
        Toast.makeText(context, "Okно закрыто", Toast.LENGTH_LONG).show()
    }
}