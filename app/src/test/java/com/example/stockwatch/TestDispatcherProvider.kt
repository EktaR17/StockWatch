package com.example.stockwatch

import com.example.stockwatch.core.DispatcherProvider
import com.example.stockwatch.ui.watchlist.WatchlistViewModel
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.TestDispatcher
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestWatcher
import org.junit.runner.Description

class TestDispatcherProvider(d: TestDispatcher = UnconfinedTestDispatcher()) : DispatcherProvider {
    override val main = d
    override val io = d
    override val default = d
}

class MainDispatcherRule(private val d: TestDispatcher = UnconfinedTestDispatcher()) : TestWatcher() {
    override fun starting(description: Description) = Dispatchers.setMain(d)
    override fun finished(description: Description) = Dispatchers.resetMain()
}

// test/.../WatchlistViewModelTest.kt
class WatchlistViewModelTest {
    @get:Rule
    val rule = MainDispatcherRule()

    @Test
    fun `loads default symbols`() = runTest {
        val vm = WatchlistViewModel(TestDispatcherProvider())
        assertEquals(4, vm.symbols.value.size)
    }
}