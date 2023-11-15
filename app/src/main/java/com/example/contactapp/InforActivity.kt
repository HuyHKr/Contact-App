package com.example.contactapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class InforActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_infor)
        val contact_id = findViewById<TextView>(R.id.contact_id)
        val contact_name = findViewById<TextView>(R.id.contact_name)
        val contact_phone = findViewById<TextView>(R.id.contact_number)
        val contact_email = findViewById<TextView>(R.id.contact_address)
        val sms_button = findViewById<Button>(R.id.sms)
        val call_button = findViewById<Button>(R.id.call)
        contact_id.text = "Id: ${intent.getIntExtra("id",0)}"
        contact_name.text = "Name: ${intent.getStringExtra("name")}"
        contact_phone.text = "Phone: ${intent.getStringExtra("phone")}"
        contact_email.text = "Email: ${intent.getStringExtra("email")}"
        sms_button.setOnClickListener{
            val intent = Intent(Intent.ACTION_SEND)
            intent.data = Uri.parse("smsto:${this.intent.getStringExtra("phone")}")
            startActivity(intent)

        }
        call_button.setOnClickListener{
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:${this.intent.getStringExtra("phone")}")
            startActivity(intent);
        }
    }

}