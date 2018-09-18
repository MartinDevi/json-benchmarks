package com.dashlane.benchmarks.json.test5

import com.google.gson.annotations.SerializedName

import org.immutables.gson.Gson
import org.immutables.value.Value

@Gson.TypeAdapters
@Value.Immutable
interface JsonInterface2 {
    @get:SerializedName(JsonEntity2.A)
    val a: String
    @get:SerializedName(JsonEntity2.B)
    val b: Int
    @get:SerializedName(JsonEntity2.C)
    val c: Long
    @get:SerializedName(JsonEntity2.D)
    val d: Float
    @get:SerializedName(JsonEntity2.E)
    val e: Double
    @get:SerializedName(JsonEntity2.F)
    val f: Boolean
}
