package com.android.fundamentals.workshop04.task

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.fundamentals.R
import com.android.fundamentals.workshop04.SampleBottomSheet
import com.google.android.material.snackbar.Snackbar
import java.util.*

class WS04AssignmentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ws04)

        var date: Calendar

        findViewById<Button>(R.id.btn_show_alert_dialog)?.apply {
            setOnClickListener {
                // TODO(WS4:1) set title, positive, negative and neutral buttons for AlertDialog.
                //  Make it show Toast when pressing button and show in toast what button was pressed
                //  * Make it show Toast about cancelling dialog only when it is closed by tapping outside
                //  * Make dialog not to be closed when tapped outside of fragment
                //  AlertDialog.Builder(context)
                //  .show()

                AlertDialog.Builder(context)
                    .setTitle("Alert!!")
                    .setPositiveButton("ok") { _, _ ->
                        Toast.makeText(context, "Ok", Toast.LENGTH_LONG).show()
                    }
                    .setNegativeButton("cancel") { _, _ ->
                        Toast.makeText(context, "cancel", Toast.LENGTH_LONG).show()

                    }.setNeutralButton("Retry") {  _, _ ->
                        Toast.makeText(context, "Retry", Toast.LENGTH_LONG).show()

                    }.setOnCancelListener {
                    Toast.makeText(context, "Окно закрыто", Toast.LENGTH_LONG).show() }
                    .setCancelable(true)
                    .create()
                    .show()
            }
        }

        findViewById<Button>(R.id.btn_show_dialog_fragment)?.apply {
            setOnClickListener {
                // TODO(WS4:2) show dialog fragment SampleDialogFragment.
                //  Change SampleDialogFragment to make it show Toasts as in alert dialog (previous task)
//                supportFragmentManager.beginTransaction().add(R.id.main_container, WS04AssignmentDialogFragment()).commit()
                val dialogFragment = WS04AssignmentDialogFragment()
                dialogFragment.show(supportFragmentManager, null)
            }
        }

        findViewById<Button>(R.id.btn_show_time_picker)?.apply {
            setOnClickListener {
                // TODO(WS4:3) make timePickerDialog to start with current time
                //  Show Snackbar with selected time
                date = Calendar.getInstance()
                val timePickerDialog = TimePickerDialog(
                    this@WS04AssignmentActivity,
                    { _, p2, p3 ->
                        Snackbar.make(
                                findViewById(R.id.btn_show_time_picker),
                                "you choosed time: $p2:$p3",
                                Snackbar.LENGTH_LONG
                        )
                                .show()
                    },
                    date.get(Calendar.HOUR_OF_DAY),
                    date.get(Calendar.MINUTE),
                    true
                )

                timePickerDialog.show()
            }
        }

        findViewById<Button>(R.id.btn_show_date_picker)?.apply {
            setOnClickListener {
                // TODO(WS4:4) make timePickerDialog to start with today date
                //  Show Snackbar with selected datek
                date = Calendar.getInstance()
                val datePickerDialog = DatePickerDialog(
                    context,
                    { _, p1, p2, p3 ->
                        Snackbar.make(
                            findViewById(R.id.btn_show_date_picker),
                            "you choosed date: $p3/${p2+1}/$p1",
                            Snackbar.LENGTH_LONG
                        )
                            .show()
                    },
                    date.get(Calendar.YEAR),
                    date.get(Calendar.MONTH),
                    date.get(Calendar.DAY_OF_MONTH)
                )

                datePickerDialog.show()
            }
        }

        findViewById<Button>(R.id.btn_show_bottom_sheet_dialog)?.apply {
            setOnClickListener {
                // TODO(WS4:5) show dialog fragment SampleBottomSheet
                //  Look at difference between dialogFragment and BottomSheetFragment layouts drawing  and change dialog_fragment to show buttons under textview
                val dialog = SampleBottomSheet()
                dialog.show(supportFragmentManager, null)
            }
        }
    }
}