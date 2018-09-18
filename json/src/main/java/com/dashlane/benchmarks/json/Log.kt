package com.dashlane.benchmarks.json

import kotlin.properties.Delegates

/**
 * Logger.
 */
object Log {

    var level by Delegates.observable(Level.QUIET) { _, _, value ->
        v = if (value.ordinal > Level.VERBOSE.ordinal) disabled else enabled
        d = if (value.ordinal > Level.DEBUG.ordinal) disabled else enabled
        i = if (value.ordinal > Level.INFO.ordinal) disabled else enabled
        w = if (value.ordinal > Level.WARN.ordinal) disabled else enabled
        e = if (value.ordinal > Level.ERROR.ordinal) disabled else enabled
    }

    val printers = mutableListOf<(String) -> Unit>(
            { println(it) }
    )

    private val enabled: (String) -> Unit = { printers.forEach { print -> print(it) } }
    private val disabled: (String) -> Unit = {}

    private var v = disabled
    private var d = disabled
    private var i = disabled
    private var w = disabled
    private var e = disabled

    fun v(message: String) = v.invoke(message)
    fun d(message: String) = d.invoke(message)
    fun i(message: String) = i.invoke(message)
    fun w(message: String) = w.invoke(message)
    fun e(message: String) = e.invoke(message)

    enum class Level {
        VERBOSE,
        DEBUG,
        INFO,
        WARN,
        ERROR,
        QUIET
    }
}