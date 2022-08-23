package com.serhohuk.main

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.viewModelScope
import com.serhohuk.core.BaseViewModel
import com.serhohuk.core.events.LoginSuccessEvent
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

/**
 * Created by serhh on 23.08.2022
 */

class MainViewModel : BaseViewModel() {

    private val stateFlow = MutableStateFlow("")
    val timeLogin = stateFlow.asStateFlow()


    fun eventObserve(){
        viewModelScope.launch {
            appNotifier.notifier.collectLatest {
                when(it){
                    is LoginSuccessEvent ->{
                        stateFlow.value = it.time
                    }
                }
            }
        }
    }
}