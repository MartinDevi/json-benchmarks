package com.dashlane.benchmarks.json

import android.content.Context
import android.content.Intent
import android.os.Parcel
import android.widget.SeekBar
import java.text.NumberFormat
import kotlin.math.roundToInt
import kotlin.math.roundToLong

typealias TestResult = Triple<Long, Long, Long>

inline fun <reified T> Context.startActivity(block: Intent.() -> Unit) =
        startActivity(Intent(this, T::class.java).apply(block))

fun Parcel.writeBoolean(value: Boolean) =
        writeByte(if (value) 1 else 0)

fun Parcel.readBoolean() =
        readByte() != 0.toByte()

fun <T> Iterable<T>.average(block: (T) -> Long) = map(block).average().roundToLong()
fun <T> Iterable<T>.average(block: (T) -> Int) = map(block).average().roundToInt()

fun formatDuration(nanos: Long) =
        "${formatThreeSignificantDigits(nanos.toDouble() / 1_000_000)}ms"

fun formatSize(bytes: Int): String = when {
    bytes <= 1_000 -> "$bytes bytes"
    bytes <= 1_000_000 -> "${formatThreeSignificantDigits(bytes.toDouble() / 1_000)} Kb"
    else -> "${formatThreeSignificantDigits(bytes.toDouble() / 1_000_000)} Mb"
}

fun formatThreeSignificantDigits(value: Double): String = when {
    value < 1.0 -> numberFormatWithDigits(3).format(value)
    value < 10.0 -> numberFormatWithDigits(2).format(value)
    value < 100.0 -> numberFormatWithDigits(1).format(value)
    else -> NumberFormat.getIntegerInstance().format(value)
}

fun numberFormatWithDigits(digits: Int): NumberFormat = NumberFormat.getInstance().apply {
    minimumFractionDigits = digits
    maximumFractionDigits = digits
}

inline fun <reified E: Enum<E>> ordinalName(ordinal: Int) =
        enumValues<E>()[ordinal].name

fun SeekBar.setOnSeekBarProgressChangeListener(block: (progress: Int) -> Unit) = setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener {
    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) = block(progress)
    override fun onStartTrackingTouch(seekBar: SeekBar?) {}
    override fun onStopTrackingTouch(seekBar: SeekBar?) {}
})