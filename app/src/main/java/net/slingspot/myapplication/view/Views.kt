package net.slingspot.myapplication.view

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

fun LifecycleOwner.whenCreated(block: suspend CoroutineScope.() -> Unit) =
    lifecycleScope.launch {
        repeatOnLifecycle(Lifecycle.State.CREATED) {
            block(this)
        }
    }

fun LifecycleOwner.whenStarted(block: suspend CoroutineScope.() -> Unit) =
    lifecycleScope.launch {
        repeatOnLifecycle(Lifecycle.State.STARTED) {
            block(this)
        }
    }

fun LifecycleOwner.whenResumed(block: suspend CoroutineScope.() -> Unit) =
    lifecycleScope.launch {
        repeatOnLifecycle(Lifecycle.State.RESUMED) {
            block(this)
        }
    }
