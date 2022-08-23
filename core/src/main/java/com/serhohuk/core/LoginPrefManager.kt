package com.serhohuk.core

import android.content.Context
import android.content.SharedPreferences

/**
 * Created by serhh on 23.08.2022
 */

class LoginPrefManager(context : Context) {

    private val EMAIL = "email"
    private val LOGIN_TIME = "login_time"

    private val prefManager = context.getSharedPreferences("login_pref", Context.MODE_PRIVATE)

    var email : String
    set(value) = prefManager.edit().putString(EMAIL, value).apply()
    get() = prefManager.getString(EMAIL,"")!!

    var loginTime : String
    set(value) = prefManager.edit().putString(LOGIN_TIME, value).apply()
    get() = prefManager.getString(LOGIN_TIME,"")!!

}