package com.serhohuk.core

import androidx.lifecycle.*
import com.serhohuk.core.events.AppNotifier
import org.koin.java.KoinJavaComponent.inject

/**
 * Created by serhh on 23.08.2022
 */

open class BaseViewModel : ViewModel() {

    val appNotifier : AppNotifier by inject(AppNotifier::class.java)



}