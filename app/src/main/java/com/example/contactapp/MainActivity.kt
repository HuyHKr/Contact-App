package com.example.contactapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.View.OnCreateContextMenuListener
import android.widget.AdapterView.AdapterContextMenuInfo
import android.widget.AdapterView.OnItemLongClickListener
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.OnItemTouchListener

class MainActivity : AppCompatActivity() {
    var listContact = arrayListOf(ContactData(1, "John Doe", "1234567890", "john.doe@email.com"),
        ContactData(2, "Jane Smith", "9876543210", "jane.smith@email.com"),
        ContactData(3, "Alice Johnson", "5551234567", "alice.johnson@email.com"),
        ContactData(4, "Bob Brown", "7778889999", "bob.brown@email.com"),
        ContactData(5, "Eva White", "4445556666", "eva.white@email.com"),
        ContactData(6, "Charlie Wilson", "9998887777", "charlie.wilson@email.com"),
        ContactData(7, "Sophia Lee", "1112223333", "sophia.lee@email.com"),
        ContactData(8, "David Miller", "3334445555", "david.miller@email.com"),
         ContactData(9, "Grace Turner", "6667778888", "grace.turner@email.com"),
        ContactData(10, "Daniel Harris", "2221119999", "daniel.harris@email.com"))
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = AdapterOfApp(listContact)
        recyclerView.layoutManager = LinearLayoutManager(this)

    }







    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.option_menu,menu);
        return super.onCreateOptionsMenu(menu)
    }




}