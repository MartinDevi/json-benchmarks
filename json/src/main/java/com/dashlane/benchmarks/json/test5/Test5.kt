package com.dashlane.benchmarks.json.test5

import com.dashlane.benchmarks.json.JsonTest
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import org.json.JSONArray
import org.json.JSONObject
import java.util.*

/**
 * Deserialize a complex JSON structure having as many features (data types, recursive, ...) as
 * possible.
 */
class Test5(override val json: String): JsonTest {

    private val immutableGson: Gson = GsonBuilder().run {
        registerTypeAdapterFactory(GsonAdaptersJsonInterface1())
        registerTypeAdapterFactory(GsonAdaptersJsonInterface2())
        registerTypeAdapterFactory(GsonAdaptersJsonInterface3())
        create()
    }

    override fun parseGson() {
        Gson().fromJson(json, Array<JsonEntity1>::class.java)
    }

    override fun parseImmutableGson() {
        immutableGson.fromJson(json, Array<JsonInterface1>::class.java)
    }

    override fun parseOrgJson() {
        val jsonArray = JSONArray(json)
        val length = jsonArray.length()
        Array(length) { i ->
            val jsonObject = jsonArray.getJSONObject(i)
            parseJsonEntity1(jsonObject)
        }
    }

    private fun parseJsonEntity1(jsonObject: JSONObject) = JsonEntity1(
            jsonObject.getString(JsonEntity1.A),
            jsonObject.getInt(JsonEntity1.B),
            jsonObject.getLong(JsonEntity1.C),
            jsonObject.getDouble(JsonEntity1.D).toFloat(),
            jsonObject.getDouble(JsonEntity1.E),
            jsonObject.getBoolean(JsonEntity1.F),
            parseJsonEntity2(jsonObject.getJSONObject(JsonEntity1.G)),
            parseJsonEntity3List(jsonObject.getJSONArray(JsonEntity1.H))
    )

    private fun parseJsonEntity2(jsonObject: JSONObject) = JsonEntity2(
            jsonObject.getString(JsonEntity2.A),
            jsonObject.getInt(JsonEntity2.B),
            jsonObject.getLong(JsonEntity2.C),
            jsonObject.getDouble(JsonEntity2.D).toFloat(),
            jsonObject.getDouble(JsonEntity2.E),
            jsonObject.getBoolean(JsonEntity2.F)
    )

    private fun parseJsonEntity3List(jsonArray: JSONArray) =
            List(jsonArray.length()) { i -> parseJsonEntity3(jsonArray.getJSONObject(i)) }

    private fun parseJsonEntity3(jsonObject: JSONObject): JsonEntity3 = JsonEntity3(
            jsonObject.getString(JsonEntity3.A),
            jsonObject.getInt(JsonEntity3.B),
            jsonObject.getLong(JsonEntity3.C),
            jsonObject.getDouble(JsonEntity3.D).toFloat(),
            jsonObject.getDouble(JsonEntity3.E),
            jsonObject.getBoolean(JsonEntity3.F),
            parseJsonEntity1(jsonObject.getJSONObject(JsonEntity3.G))
    )

    companion object Factory: JsonTest.Factory {

        override val testName = "Small complex data set"

        private val random = Random()

        override fun create(): Test5 {
            val list = List(200) { createRandomEntity1(3) }
            val json = Gson().toJson(list)
            return Test5(json)
        }

        private fun createRandomEntity1(length: Int) = JsonEntity1(
                randomString(),
                randomInt(),
                randomLong(),
                randomFloat(),
                randomDouble(),
                randomBoolean(),
                createRandomEntity2(),
                createEntity3List(length)
        )

        private fun createRandomEntity2() = JsonEntity2(
                randomString(),
                randomInt(),
                randomLong(),
                randomFloat(),
                randomDouble(),
                randomBoolean()
        )

        private fun createEntity3List(size: Int) = List(size) {
            createRandomEntity3(size)
        }

        private fun createRandomEntity3(size: Int): JsonEntity3 = JsonEntity3(
                randomString(),
                randomInt(),
                randomLong(),
                randomFloat(),
                randomDouble(),
                randomBoolean(),
                createRandomEntity1(size - 1)
        )

        private fun randomString() = UUID.randomUUID().toString()
        private fun randomInt() = random.nextInt()
        private fun randomLong() = random.nextLong()
        private fun randomFloat() = random.nextFloat()
        private fun randomDouble() = random.nextDouble()
        private fun randomBoolean() = random.nextBoolean()
    }
}