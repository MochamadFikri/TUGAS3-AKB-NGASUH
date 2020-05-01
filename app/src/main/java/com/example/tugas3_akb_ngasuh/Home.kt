package com.example.tugas3_akb_ngasuh

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tugas3_akb_ngasuh.SharedPreference.Preferences
import kotlinx.android.synthetic.main.home.*

// NIM   : 10117198
// Nama  : Mochamad Fikri Fadila Akbar
// Kelas : IF5
// Pengerjaan : 1 Mei 2020


class Home : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home)
        declareView()

        home_btn.setOnClickListener(){
            val Preferences = Preferences(baseContext)
            Preferences.setLogout(baseContext)

            startActivity(Intent(this, Login::class.java))
            finish()
        }

    }
    fun declareView(){
        val preferences = Preferences(baseContext)
        home_username.text = preferences.getRegisteredUser(baseContext)
    }
}
