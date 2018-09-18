package com.dashlane.benchmarks.json.test4

import com.google.gson.annotations.SerializedName

import org.immutables.gson.Gson
import org.immutables.value.Value

@Gson.TypeAdapters
@Value.Immutable
interface JsonInterface {

    @get:SerializedName(JsonEntity.A)
    val a: List<JsonInterface>
    @get:SerializedName(JsonEntity.B)
    val b: List<JsonInterface>
    @get:SerializedName(JsonEntity.C)
    val c: List<JsonInterface>
    @get:SerializedName(JsonEntity.D)
    val d: List<JsonInterface>
}
