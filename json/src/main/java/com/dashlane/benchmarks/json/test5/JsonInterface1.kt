package com.dashlane.benchmarks.json.test5

import com.google.gson.annotations.SerializedName

import org.immutables.gson.Gson
import org.immutables.value.Value

@Gson.TypeAdapters
@Value.Immutable
interface JsonInterface1 {

    @get:SerializedName(JsonEntity1.A)
    val a: String
    @get:SerializedName(JsonEntity1.B)
    val b: Int
    @get:SerializedName(JsonEntity1.C)
    val c: Long
    @get:SerializedName(JsonEntity1.D)
    val d: Float
    @get:SerializedName(JsonEntity1.E)
    val e: Double
    @get:SerializedName(JsonEntity1.F)
    val f: Boolean
    @get:SerializedName(JsonEntity1.G)
    val g: JsonInterface2
    @get:SerializedName(JsonEntity1.H)
    val h: List<JsonInterface3>
}
