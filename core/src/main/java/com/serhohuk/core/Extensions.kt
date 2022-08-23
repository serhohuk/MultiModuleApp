package com.serhohuk.core

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.Fragment

/**
 * Created by serhh on 23.08.2022
 */

fun Fragment.toast(text : String){
    Toast.makeText(this.requireActivity(), text, Toast.LENGTH_SHORT).show()
}