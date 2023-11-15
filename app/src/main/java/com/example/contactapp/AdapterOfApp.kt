package com.example.contactapp

import android.content.Intent
import android.net.Uri
import android.view.ContextMenu
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.View.OnCreateContextMenuListener
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView

class  AdapterOfApp(val items:ArrayList<ContactData>):RecyclerView.Adapter<AdapterOfApp.AppViewHolder>() {
    class AppViewHolder(var view: View):RecyclerView.ViewHolder(view){

        var v = view
        var photo = view.findViewById<TextView>(R.id.tag)
        var textView = view.findViewById<TextView>(R.id.textView)


        }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item,parent,false)
        return AppViewHolder(view)

    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: AppViewHolder, position: Int) {
        holder.photo.text = (items[position].name)[0].toString()
        holder.textView.text = items[position].name
        holder.v.setOnClickListener{
            val intent =Intent(holder.v.context,InforActivity::class.java)
            intent.putExtra("id",items[position].id)
            intent.putExtra("name",items[position].name)
            intent.putExtra("phone",items[position].phoneNumber)
            intent.putExtra("email",items[position].email)
            holder.v.context.startActivity(intent)
        }
        holder.v.setOnCreateContextMenuListener(object:OnCreateContextMenuListener{
            override fun onCreateContextMenu(
                menu: ContextMenu?,
                v: View?,
                menuInfo: ContextMenu.ContextMenuInfo?
            ) {
                val call = menu?.add(Menu.NONE,1,0,"Call")
                val sms = menu?.add(Menu.NONE,2,1,"Sms")
                call?.setOnMenuItemClickListener {
                    val intent = Intent(Intent.ACTION_DIAL)
                    intent.data = Uri.parse("tel:${items[position].phoneNumber}")
                    v?.context?.startActivity(intent)
                    true
                }
                sms?.setOnMenuItemClickListener {
                    val intent = Intent(Intent.ACTION_SEND)
                    intent.data = Uri.parse("smsto:${items[position].phoneNumber}")
                    v?.context?.startActivity(intent)
                    true
                }
            }

        })

    }


}