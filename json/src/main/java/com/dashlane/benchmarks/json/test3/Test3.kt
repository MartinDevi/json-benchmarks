package com.dashlane.benchmarks.json.test3

import com.dashlane.benchmarks.json.JsonTest
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import org.json.JSONArray
import org.json.JSONObject

/**
 * Deserialize a deep recursive hierarchy of JSON objects containing other JSON objects with the
 * same structure.
 */
class Test3(override val json: String): JsonTest {

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

    private fun parseJsonEntity(jsonObject: JSONObject): JsonEntity = JsonEntity(
            jsonObject.optJSONObject(JsonEntity.A)?.let { parseJsonEntity(it) },
            jsonObject.optJSONObject(JsonEntity.B)?.let { parseJsonEntity(it) },
            jsonObject.optJSONObject(JsonEntity.C)?.let { parseJsonEntity(it) },
            jsonObject.optJSONObject(JsonEntity.D)?.let { parseJsonEntity(it) }
    )

    companion object Factory: JsonTest.Factory {

        override val testName = "Deep data set"

        override fun create(): Test3 {
            val list = List(1_000) { createRandomEntity() }
            val json = Gson().toJson(list)
            return Test3(json)
        }

        private fun createRandomEntity() = JsonEntity(
                createOptRandomEntity(4),
                createOptRandomEntity(3),
                createOptRandomEntity(2),
                createOptRandomEntity(1)
        )

        private fun createOptRandomEntity(seed: Int): JsonEntity? {
            return if (seed <= 0) {
                null
            } else {
                JsonEntity(
                        createOptRandomEntity(seed - 1),
                        createOptRandomEntity(seed - 2),
                        createOptRandomEntity(seed - 3),
                        createOptRandomEntity(seed - 4)
                )
            }
        }
    }
}