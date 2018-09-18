package com.dashlane.benchmarks.json.test3

import com.google.gson.annotations.SerializedName

import org.immutables.gson.Gson
import org.immutables.value.Value

@Gson.TypeAdapters
@Value.Immutable
interface JsonInterface {

    @get:SerializedName(JsonEntity.A)
    val a: JsonInterface?
    @get:SerializedName(JsonEntity.B)
    val b: JsonInterface?
    @get:SerializedName(JsonEntity.C)
    val c: JsonInterface?
    @get:SerializedName(JsonEntity.D)
    val d: JsonInterface?
}
