package com.dashlane.benchmarks.json.test2

import com.google.gson.annotations.SerializedName
import org.immutables.gson.Gson
import org.immutables.value.Value

@Gson.TypeAdapters
@Value.Immutable
interface JsonInterface1 {

    @get:SerializedName(JsonEntity1.A)
    val a: List<JsonInterface2>
    @get:SerializedName(JsonEntity1.B)
    val b: List<JsonInterface2>
    @get:SerializedName(JsonEntity1.C)
    val c: List<JsonInterface2>
    @get:SerializedName(JsonEntity1.D)
    val d: List<JsonInterface2>
}
