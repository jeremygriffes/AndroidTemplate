package net.slingspot.androidlogger

import android.util.Log
import io.mockk.every
import io.mockk.mockkStatic
import io.mockk.slot
import net.slingspot.androidlogger.LogLevel.VERBOSE
import net.slingspot.androidlogger.LogLevel.WARN
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class LogcatLoggerTest {
    private val logSlot = slot<String>()

    @Before
    fun before() {
        mockkStatic(Log::class)
        every { Log.v(any(), capture(logSlot)) } returns 0
        every { Log.d(any(), capture(logSlot)) } returns 0
        every { Log.i(any(), capture(logSlot)) } returns 0
        every { Log.w(any(), capture(logSlot)) } returns 0
        every { Log.e(any(), capture(logSlot)) } returns 0
        every { Log.e(any(), capture(logSlot), any()) } returns 0
    }

    @Test
    fun `minimum log level prevents logging`() {
        val verboseLog = LogcatLogger(VERBOSE)

        verboseLog.v(tag) { "v" }
        assertEquals("v", logSlot.captured)

        verboseLog.d(tag) { "d" }
        assertEquals("d", logSlot.captured)

        verboseLog.i(tag) { "i" }
        assertEquals("i", logSlot.captured)

        verboseLog.w(tag) { "w" }
        assertEquals("w", logSlot.captured)

        verboseLog.e(tag) { "e" }
        assertEquals("e", logSlot.captured)

        logSlot.clear()

        val warnLog = LogcatLogger(WARN)
        warnLog.v(tag) { "v" }
        assertFalse(logSlot.isCaptured)

        warnLog.d(tag) { "d" }
        assertFalse(logSlot.isCaptured)

        warnLog.i(tag) { "i" }
        assertFalse(logSlot.isCaptured)

        warnLog.w(tag) { "w" }
        assertEquals("w", logSlot.captured)

        warnLog.e(tag) { "e" }
        assertEquals("e", logSlot.captured)
    }

    @Test
    fun `null message translates to 'null' text`() {
        LogcatLogger().i(tag) { null }
        assertEquals("null", logSlot.captured)
    }

    @Test
    fun `exceptions thrown in message construction translates to exception text`() {
        LogcatLogger().i(tag) { throw Exception("whoops") }
        assertTrue(logSlot.captured.contains("whoops"))
    }

    companion object {
        const val tag = "test"
    }
}
