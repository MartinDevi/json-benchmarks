package com.dashlane.benchmarks.json.test1

import com.google.gson.annotations.SerializedName

import org.immutables.gson.Gson
import org.immutables.value.Value

@Gson.TypeAdapters
@Value.Immutable
interface JsonInterface {

    @get:SerializedName(JsonEntity.A)
    val a: String
    @get:SerializedName(JsonEntity.B)
    val b: String
    @get:SerializedName(JsonEntity.C)
    val c: Int
    @get:SerializedName(JsonEntity.D)
    val d: Int
    @get:SerializedName(JsonEntity.E)
    val e: Boolean
    @get:SerializedName(JsonEntity.F)
    val f: Boolean
}
