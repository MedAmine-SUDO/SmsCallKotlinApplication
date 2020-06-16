package com.example.mysecondandroidproject

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresPermission
import kotlinx.android.synthetic.main.activity_confirm_s_m_s.*

class ConfirmSMS : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirm_s_m_s)

        confirm_btn.setOnClickListener {
            val telNbr = telNbrValue.text.toString()
            val msg = messageValue.text.toString()
            intent = Intent(applicationContext, WriteSMS::class.java)
            intent.putExtra("Tel Number", telNbr)
            intent.putExtra("Message Body", msg)
            startActivityForResult(intent, 1)
        }
    }
    override fun onActivityResult(requestCode:Int, resultCode:Int, data:Intent?){
        super.onActivityResult(requestCode, resultCode, data)
        when(requestCode){
            1 ->
                when(resultCode){
                    Activity.RESULT_CANCELED -> {
                        val msg = data!!.getStringExtra("TOAST MESSAGE")
                        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
                    }
                    else -> Toast.makeText(this, "All good", Toast.LENGTH_LONG).show()
                }
        }
    }

}