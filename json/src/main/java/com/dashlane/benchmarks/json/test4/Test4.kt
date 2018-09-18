package com.dashlane.benchmarks.json.test4

import com.dashlane.benchmarks.json.JsonTest
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import org.json.JSONArray
import org.json.JSONObject
import kotlin.math.max

/**
 * Deserialize a deep recursive hierarchy of JSON objects containing lists of JSON objects with the
 * same structure.
 */
class Test4(override val json: String): JsonTest {

    private val immutableGson: Gson = GsonBuilder().run {
        registerTypeAdapterFactory(GsonAdaptersJsonInterface())
        create()
    }

    override fun parseGson() {
        Gson().fromJson(json, Array<JsonEntity>::class.java)
    }

    override fun parseImmutableGson() {
        immutableGson.fromJson(json, Array<JsonInterface>::class.java)
    }

    override fun parseOrgJson() {
        val jsonArray = JSONArray(json)
        val length = jsonArray.length()
        Array(length) { i ->
            val jsonObject = jsonArray.getJSONObject(i)
            parseJsonEntity(jsonObject)
        }
    }

    private fun parseJsonEntity(jsonObject: JSONObject) = JsonEntity(
            parseJsonEntityList(jsonObject.getJSONArray(JsonEntity.A)),
            parseJsonEntityList(jsonObject.getJSONArray(JsonEntity.B)),
            parseJsonEntityList(jsonObject.getJSONArray(JsonEntity.C)),
            parseJsonEntityList(jsonObject.getJSONArray(JsonEntity.D))
    )

    private fun parseJsonEntityList(jsonArray: JSONArray): List<JsonEntity> =
            List(jsonArray.length()) { i -> parseJsonEntity(jsonArray.getJSONObject(i)) }

    companion object Factory: JsonTest.Factory {

        override val testName = "Deep lists data set"

        override fun create(): Test4 {
            val list = List(200) { createRandomEntity() }
            val json = Gson().toJson(list)
            return Test4(json)
        }

        private fun createRandomEntity() = JsonEntity(
                createRandomEntityList(4),
                createRandomEntityList(3),
                createRandomEntityList(2),
                createRandomEntityList(1)
        )

        private fun createRandomEntityList(length: Int): List<JsonEntity> = List(max(length, 0)) {
            JsonEntity(
                    createRandomEntityList(length - 1),
                    createRandomEntityList(length - 2),
                    createRandomEntityList(length - 3),
                    createRandomEntityList(length - 4)
            )
        }
    }
}