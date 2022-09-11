package net.slingspot.myapplication

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import net.slingspot.core.log.Logger
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    app: Application,
    private val log: Logger
) : AndroidViewModel(app) {

    companion object {
        private const val TAG = "MainViewModel"
    }
}
