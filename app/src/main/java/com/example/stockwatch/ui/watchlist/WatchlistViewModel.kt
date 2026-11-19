package com.example.stockwatch.ui.watchlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.stockwatch.core.DispatcherProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@HiltViewModel
class WatchlistViewModel @Inject constructor(
    private val dispatchers: DispatcherProvider
) : ViewModel() {

    private val _symbols = MutableStateFlow<List<String>>(emptyList())
    val symbols = _symbols.asStateFlow()

    init {
        viewModelScope.launch {
            _symbols.value = withContext(dispatchers.io) { listOf("RELIANCE", "TCS", "INFY", "HDFCBANK") }
        }
    }
}