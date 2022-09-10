package net.slingspot.androidlogger

import android.util.Log
import io.mockk.every
import io.mockk.mockkStatic
import io.mockk.slot
import net.slingspot.androidlogger.LogLevel.VERBOSE
import net.slingspot.androidlogger.LogLevel.WARN
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class LogcatLoggerTest {
    private val logSlot = slot<String>()

    init {
        mockkStatic(Log::class)
        every { Log.v(any(), capture(logSlot)) } returns 0
        every { Log.d(any(), capture(logSlot)) } returns 0
        every { Log.i(any(), capture(logSlot)) } returns 0
        every { Log.w(any(), capture(logSlot)) } returns 0
        every { Log.e(any(), capture(logSlot)) } returns 0
        every { Log.e(any(), capture(logSlot), any()) } returns 0
    }

    @Nested
    @DisplayName("Given a log level of VERBOSE")
    inner class VerboseLog {
        val log = LogcatLogger(VERBOSE)

        @Nested
        @DisplayName("when logging verbose, then")
        inner class WhenVerbose {
            init {
                log.v(tag) { "v" }
            }

            @Test
            @DisplayName("message is logged")
            fun then() {
                assertEquals("v", logSlot.captured)
            }
        }

        @Nested
        @DisplayName("when logging error, then")
        inner class WhenError {
            init {
                log.e(tag) { "e" }
            }

            @Test
            @DisplayName("message is logged")
            fun then() {
                assertEquals("e", logSlot.captured)
            }
        }
    }

    @Nested
    @DisplayName("Given a log level of WARN")
    inner class WarnLog {
        val log = LogcatLogger(WARN)

        @Nested
        @DisplayName("when logging verbose, then")
        inner class WhenVerbose {
            init {
                log.v(tag) { "v" }
            }

            @Test
            @DisplayName("nothing is logged")
            fun then() {
                assertFalse(logSlot.isCaptured)
            }
        }

        @Nested
        @DisplayName("when logging info, then")
        inner class WhenInfo {
            init {
                log.i(tag) { "i" }
            }

            @Test
            @DisplayName("nothing is logged")
            fun then() {
                assertFalse(logSlot.isCaptured)
            }
        }

        @Nested
        @DisplayName("when logging warn, then")
        inner class WhenWarn {
            init {
                log.w(tag) { "w" }
            }

            @Test
            @DisplayName("message is logged")
            fun then() {
                assertEquals("w", logSlot.captured)
            }
        }

        @Nested
        @DisplayName("when logging error, then")
        inner class WhenError {
            init {
                log.e(tag) { "e" }
            }

            @Test
            @DisplayName("message is logged")
            fun then() {
                assertEquals("e", logSlot.captured)
            }
        }
    }

    @Nested
    @DisplayName("Given a logger")
    inner class NullMessage {
        val log = LogcatLogger()

        @Nested
        @DisplayName("when logging a null message, then")
        inner class WhenNull {
            init {
                log.i(tag) { null }
            }

            @Test
            @DisplayName("message translates to 'null' text")
            fun then() {
                assertEquals("null", logSlot.captured)
            }
        }

        @Nested
        @DisplayName("when throwing an exception in the message function, then")
        inner class WhenException {
            init {
                log.i(tag) { throw Exception("whoops") }
            }

            @Test
            @DisplayName("message translates to exception text")
            fun then() {
                assertTrue(logSlot.captured.contains("whoops"))
            }
        }
    }

    companion object {
        const val tag = "test"
    }
}
