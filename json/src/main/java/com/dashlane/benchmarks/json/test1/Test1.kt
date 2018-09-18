package com.dashlane.benchmarks.json.test1

import com.dashlane.benchmarks.json.JsonTest
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import org.json.JSONArray
import org.json.JSONObject
import java.util.*

/**
 * Deserialize a list of JSON objects with simple primitive type fields.
 */
class Test1(override val json: String): JsonTest {

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
        Array(jsonArray.length()) { i ->
            val jsonObject = jsonArray.getJSONObject(i)
            parseJsonEntity(jsonObject)
        }
    }

    private fun parseJsonEntity(jsonObject: JSONObject) = JsonEntity(
            jsonObject.getString(JsonEntity.A),
            jsonObject.getString(JsonEntity.B),
            jsonObject.getInt(JsonEntity.C),
            jsonObject.getInt(JsonEntity.D),
            jsonObject.getBoolean(JsonEntity.E),
            jsonObject.getBoolean(JsonEntity.F)
    )

    companion object Factory {

        private val random = Random()

        val Small = this(200)
        val Large = this(5_000)

        operator fun invoke(size: Int) = object: JsonTest.Factory {
            override val testName = "Flat data set ($size items)"
            override fun create(): JsonTest = create(size)
        }

        private fun create(size: Int): Test1 {
            val list = List(size) { createRandomEntity() }
            val json = Gson().toJson(list)
            return Test1(json)
        }

        private fun createRandomEntity() = JsonEntity(
                randomString(),
                randomString(),
                randomInt(),
                randomInt(),
                randomBoolean(),
                randomBoolean()
        )

        private fun randomString() = UUID.randomUUID().toString()
        private fun randomInt() = random.nextInt()
        private fun randomBoolean() = random.nextBoolean()
    }
}