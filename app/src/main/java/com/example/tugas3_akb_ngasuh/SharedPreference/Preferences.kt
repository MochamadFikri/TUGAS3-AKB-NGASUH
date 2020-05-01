package com.example.tugas3_akb_ngasuh.SharedPreference

import android.content.Context
import com.example.tugas3_akb_ngasuh.Model.Model

class Preferences(private val context: Context): UtilStatic{
    private val PREF_SESSION = "com.example.tugas3_akb_ngasuh.session"
    private val REGISTER_USERNAME = "REGISTER_USERNAME"
    private val REGISTER_PASSWORD = "REGISTER_PASSWORD"
    private val REGISTER_PHONE = "REGISTER_PHONE"
    private val LOGIN_STATUS = "LOGIN_STATUS"

    fun setUserPreferences(context: Context, Model: Model){
        val sharedPref = context.getSharedPreferences(PREF_SESSION,Context.MODE_PRIVATE)
        with(sharedPref.edit()){
            this.putString(REGISTER_USERNAME, Model.username)
            this.putString(REGISTER_PASSWORD, Model.password)
            this.putString(REGISTER_PHONE, Model.phone)
            this.apply()
        }
    }
    fun getRegisteredUser(context: Context):String?{
        val sharedPref = context.getSharedPreferences(PREF_SESSION,Context.MODE_PRIVATE)
        return sharedPref.getString(REGISTER_USERNAME, DEFAULT_STRING)
    }
    fun getRegisteredPassword(context: Context):String?{
        val sharedPref = context.getSharedPreferences(PREF_SESSION,Context.MODE_PRIVATE)
        return sharedPref.getString(REGISTER_PASSWORD, DEFAULT_STRING)
    }
    fun getRegisteredPhone(context: Context):String?{
        val sharedPref = context.getSharedPreferences(PREF_SESSION,Context.MODE_PRIVATE)
        return sharedPref.getString(REGISTER_PHONE, DEFAULT_STRING)
    }
    fun setLoggedInStatus(context: Context, statusLogin:Boolean){
        val sharedPref = context.getSharedPreferences(LOGIN_STATUS,Context.MODE_PRIVATE)
        with(sharedPref.edit()){
            this.putBoolean(LOGIN_STATUS,statusLogin)
            this.apply()
        }
    }
    fun getLoggedInStatus(context: Context):Boolean?{
        val sharedPref = context.getSharedPreferences(PREF_SESSION,Context.MODE_PRIVATE)
        return sharedPref.getBoolean(LOGIN_STATUS,DEFAULT_BOOLEAN)
    }
    fun setLogout(context: Context){
        val sharedPref = context.getSharedPreferences(PREF_SESSION,Context.MODE_PRIVATE)
        with(sharedPref.edit()){
            this.remove(LOGIN_STATUS)
            this.apply()
        }
    }
}