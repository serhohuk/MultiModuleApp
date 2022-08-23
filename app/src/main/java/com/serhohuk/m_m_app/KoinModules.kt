package com.serhohuk.m_m_app

import com.serhohuk.auth.AuthViewModel
import com.serhohuk.core.events.AppNotifier
import com.serhohuk.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


/**
 * Created by serhh on 23.08.2022
 */

val module = module {

    single {
        AppNotifier()
    }

    viewModel{
        MainViewModel()
    }

    viewModel{
        AuthViewModel()
    }

}