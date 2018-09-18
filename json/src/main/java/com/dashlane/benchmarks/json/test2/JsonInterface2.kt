package com.dashlane.benchmarks.json.test2

import com.google.gson.annotations.SerializedName

import org.immutables.gson.Gson
import org.immutables.value.Value

@Gson.TypeAdapters
@Value.Immutable
interface JsonInterface2 {
    @get:SerializedName(JsonEntity2.A)
    val a: String
    @get:SerializedName(JsonEntity2.B)
    val b: String
    @get:SerializedName(JsonEntity2.C)
    val c: String
    @get:SerializedName(JsonEntity2.D)
    val d: String
}
