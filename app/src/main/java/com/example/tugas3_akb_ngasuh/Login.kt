package com.example.tugas3_akb_ngasuh

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.tugas3_akb_ngasuh.Model.Model
import com.example.tugas3_akb_ngasuh.SharedPreference.Preferences
import kotlinx.android.synthetic.main.activity_main.*

// NIM   : 10117198
// Nama  : Mochamad Fikri Fadila Akbar
// Kelas : IF5
// Pengerjaan : 1 Mei 2020


class Login : AppCompatActivity() {

    private lateinit var sharePref : Preferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharePref = Preferences(baseContext)

        login_btn.setOnClickListener(){
            val username = login_username.text.toString()
            val password = login_password.text.toString()
            validasiForm(username,password)
        }

        login_btn2.setOnClickListener(){
            val intent = Intent(this, Register::class.java)
            startActivity(intent)
            finish()
        }
    }

    fun Login(user: String,pass: String){
        val userModel = Model(user,pass,"")

        sharePref.setUserPreferences(baseContext,userModel) //
        sharePref.setLoggedInStatus(baseContext,true)

        startActivity(Intent(baseContext,Home::class.java))
        finish()
    }

    fun cekUser(user: String):Boolean{
        return user.equals(sharePref.getRegisteredUser(baseContext))
    }

    fun cekPass(pass: String): Boolean{
        return pass.equals(sharePref.getRegisteredPassword(baseContext))
    }

    // Validasi Form
    fun validasiForm(user:String,pass: String){
        if(user.isEmpty()){
            login_username.error = "Username tidak boleh kosong"
            return
        }
        if(pass.isEmpty()){
            login_password.error = "Password tidak boleh kosong"
            return
        }

        if(cekUser(user) == true && cekPass(pass)){
            Login(user,pass)
        }
        else{
            Toast.makeText(baseContext,"Mohon Register Terlebih Dahulu",Toast.LENGTH_LONG).show()
        }
    }
}