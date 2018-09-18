package com.dashlane.benchmarks.json.test5

import com.google.gson.annotations.SerializedName

import org.immutables.gson.Gson
import org.immutables.value.Value

@Gson.TypeAdapters
@Value.Immutable
interface JsonInterface3 {
    @get:SerializedName(JsonEntity3.A)
    val a: String
    @get:SerializedName(JsonEntity3.B)
    val b: Int
    @get:SerializedName(JsonEntity3.C)
    val c: Long
    @get:SerializedName(JsonEntity3.D)
    val d: Float
    @get:SerializedName(JsonEntity3.E)
    val e: Double
    @get:SerializedName(JsonEntity3.F)
    val f: Boolean
    @get:SerializedName(JsonEntity3.G)
    val g: JsonInterface1
}
