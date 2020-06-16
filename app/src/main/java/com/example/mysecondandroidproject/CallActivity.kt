package com.example.mysecondandroidproject

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_call.*

class CallActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_call)

        call_btn.setOnClickListener {
            val nbr = call_nbr.text.toString()
            intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:"+nbr))
            startActivity(intent)
        }

        cancel_btn.setOnClickListener {
            setResult(Activity.RESULT_CANCELED)
            finish()
        }
    }
}