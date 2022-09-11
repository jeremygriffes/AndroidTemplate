package net.slingspot.androidlogger

import android.util.Log
import net.slingspot.androidlogger.LogLevel.*
import net.slingspot.core.log.Logger
import net.slingspot.core.log.Message

enum class LogLevel {
    VERBOSE,
    DEBUG,
    INFO,
    WARN,
    ERROR
}

class LogcatLogger(private val minLoggingLevel: LogLevel = INFO) : Logger {

    override fun v(tag: String, message: Message) {
        log(VERBOSE, tag, null, message)
    }

    override fun d(tag: String, message: Message) {
        log(DEBUG, tag, null, message)
    }

    override fun i(tag: String, message: Message) {
        log(INFO, tag, null, message)
    }

    override fun w(tag: String, message: Message) {
        log(WARN, tag, null, message)
    }

    override fun e(tag: String, throwable: Throwable?, message: Message) {
        log(ERROR, tag, throwable, message)
    }

    private fun log(level: LogLevel, tag: String, throwable: Throwable?, message: Message) {
        if (level >= minLoggingLevel) {
            val msg = try {
                message.invoke()?.toString() ?: "null"
            } catch (e: Throwable) {
                "Log statement threw an exception: ${e.message}"
            }

            when (level) {
                VERBOSE -> Log.v(tag, msg)
                DEBUG -> Log.d(tag, msg)
                INFO -> Log.i(tag, msg)
                WARN -> Log.w(tag, msg)
                ERROR -> Log.e(tag, msg, throwable)
            }
        }
    }
}
