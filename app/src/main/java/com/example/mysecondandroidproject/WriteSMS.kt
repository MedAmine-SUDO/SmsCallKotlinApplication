package com.example.mysecondandroidproject

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_write_s_m_s.*

class WriteSMS : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_write_s_m_s)

        val intent = intent
        val nbrTel = intent.getStringExtra("Tel Number")
        val msg = intent.getStringExtra("Message Body")
        telNbr.setText(nbrTel)
        messageText.setText(msg)
        send_btn.setOnClickListener {
            val uri = Uri.parse("smsto:"+nbrTel+"?body="+msg)
            val intent = Intent(Intent.ACTION_SENDTO, uri)
            startActivity(intent)
        }

        cancel_btn.setOnClickListener {
            val intent: Intent = Intent()
            intent.putExtra("TOAST MESSAGE", "Send declined")
            setResult(Activity.RESULT_CANCELED, intent)
            finish()
        }
    }
}