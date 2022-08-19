package net.slingspot.myapplication

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import net.slingspot.core.Logger
import net.slingspot.core.Repository
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    app: Application,
    private val repository: Repository,
    private val log: Logger
) : AndroidViewModel(app) {
    private val _result: MutableStateFlow<String?> = MutableStateFlow(null)
    val result = _result.asStateFlow()

    private val _error: MutableStateFlow<Exception?> = MutableStateFlow(null)
    val error = _error.asStateFlow()

    fun fetch() {
        viewModelScope.launch {
            log.d(TAG) { "fetching..." }

            try {
                _result.emit(repository.fetch())
            } catch (e: Exception) {
                _error.emit(e)
            }
        }
    }

    companion object {
        private const val TAG = "MainViewModel"
    }
}
