package com.serhohuk.core


import android.text.format.DateFormat
import java.text.SimpleDateFormat
import java.util.regex.Pattern

/**
 * Created by serhh on 23.08.2022
 */

object LoginUtils {

    private val VALID_EMAIL_ADDRESS_REGEX =
        Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE)
    private val PATTERN_PASSWORD = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}"


    fun validateLogin(login : String?) : Boolean{
        if (login.isNullOrEmpty()) return false
        return VALID_EMAIL_ADDRESS_REGEX.matcher(login).find()
    }

    fun validatePassword(psswrd : String?) : Boolean{
        if (psswrd.isNullOrEmpty()) return false
        return psswrd.matches(Regex(PATTERN_PASSWORD))
    }

    fun timeInMillisToTimeString(millis: String?): String {
        if (millis.isNullOrEmpty()) return ""
        return convertDate(millis)
    }

    private fun convertDate(dateInMilliseconds: String): String {
        val time = dateInMilliseconds.toLong()
        return SimpleDateFormat("d MMM yyyy HH:mm:ss").format(time)

    }
}