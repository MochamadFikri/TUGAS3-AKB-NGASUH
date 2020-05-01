package com.example.tugas3_akb_ngasuh

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tugas3_akb_ngasuh.Model.Model
import com.example.tugas3_akb_ngasuh.SharedPreference.Preferences
import kotlinx.android.synthetic.main.register.*



// NIM   : 10117198
// Nama  : Mochamad Fikri Fadila Akbar
// Kelas : IF5
// Pengerjaan : 1 Mei 2020


class Register : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register)

        register_btn.setOnClickListener(){
            val username = register_username.text.toString()
            val password = register_password.text.toString()
            val phone = register_phone.text.toString()
            val userModel = Model(username,password,phone)
            val Preferences : Preferences = Preferences(baseContext)
            Preferences.setUserPreferences(baseContext,userModel)
            Preferences.setLoggedInStatus(baseContext,true)

            startActivity(Intent(baseContext,Home::class.java))
            finish()
        }
    }
}
