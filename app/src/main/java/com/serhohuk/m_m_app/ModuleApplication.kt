package com.serhohuk.m_m_app

import android.app.Application
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.serhohuk.auth.AuthFragment
import com.serhohuk.core.Router
import com.serhohuk.main.MainFragment
import com.serhohuk.profile.ProfileFragment

/**
 * Created by serhh on 23.08.2022
 */

class ModuleApplication : Application(), Router {


    companion object {
        lateinit var instance : ModuleApplication
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }


    override fun navigateToAuth(fm: FragmentManager) {
        fm.beginTransaction()
            .replace(R.id.fragment, AuthFragment()).commit()
    }

    override fun navigateToMain(fm: FragmentManager) {
        fm.beginTransaction()
            .replace(R.id.fragment, MainFragment()).commit()
    }

    override fun navigateToProfile(fm: FragmentManager) {
        fm.beginTransaction()
            .replace(R.id.fragment, ProfileFragment()).commit()
    }
}