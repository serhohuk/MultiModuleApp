package com.serhohuk.core.events

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow

/**
 * Created by serhh on 23.08.2022
 */

class AppNotifier {

    private val channel = MutableSharedFlow<BaseAppEvent>(replay = 0, extraBufferCapacity = 0)

    val notifier: Flow<BaseAppEvent> = channel.asSharedFlow()

    suspend fun send(event: LoginSuccessEvent) = channel.emit(event)
}