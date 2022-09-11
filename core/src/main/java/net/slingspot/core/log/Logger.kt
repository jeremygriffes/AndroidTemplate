package net.slingspot.core.log

typealias Message = () -> Any?

interface Logger {
    fun v(tag: String, message: Message)
    fun d(tag: String, message: Message)
    fun i(tag: String, message: Message)
    fun w(tag: String, message: Message)
    fun e(tag: String, throwable: Throwable? = null, message: Message)
}
