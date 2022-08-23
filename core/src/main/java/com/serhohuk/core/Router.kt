package com.serhohuk.core

import androidx.annotation.IntegerRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

/**
 * Created by serhh on 23.08.2022
 */

interface Router {

    fun navigateToAuth(
        fm: FragmentManager
    )

    fun navigateToMain(
        fm: FragmentManager
    )

    fun navigateToProfile(
        fm: FragmentManager
    )

}