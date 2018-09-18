package com.dashlane.benchmarks.json.test2

import com.dashlane.benchmarks.json.JsonTest
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import org.json.JSONArray
import org.json.JSONObject
import java.util.*

/**
 * Deserialize a list of JSON objects containing fields with lists of simple JSON objects.
 */
class Test2(override val json: String): JsonTest {

    private val immutableGson: Gson = GsonBuilder().run {
        registerTypeAdapterFactory(GsonAdaptersJsonInterface1())
        registerTypeAdapterFactory(GsonAdaptersJsonInterface2())
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
        Array(jsonArray.length()) { i ->
            val jsonObject = jsonArray.getJSONObject(i)
            parseJsonEntity1(jsonObject)
        }
    }

    private fun parseJsonEntity1(jsonObject: JSONObject): JsonEntity1 {
        return JsonEntity1(
                parseJsonEntity2List(jsonObject.getJSONArray(JsonEntity1.A)),
                parseJsonEntity2List(jsonObject.getJSONArray(JsonEntity1.B)),
                parseJsonEntity2List(jsonObject.getJSONArray(JsonEntity1.C)),
                parseJsonEntity2List(jsonObject.getJSONArray(JsonEntity1.D))
        )
    }

    private fun parseJsonEntity2List(jsonArray: JSONArray) =
            List(jsonArray.length()) { i -> parseJsonEntity2(jsonArray.getJSONObject(i)) }

    private fun parseJsonEntity2(jsonObject: JSONObject) = JsonEntity2(
            jsonObject.getString(JsonEntity2.A),
            jsonObject.getString(JsonEntity2.B),
            jsonObject.getString(JsonEntity2.C),
            jsonObject.getString(JsonEntity2.D)
    )


    companion object Factory: JsonTest.Factory {

        override val testName = "Nested data set"

        private val random = Random()

        override fun create(): Test2 {
            val list = Array(500) { createRandomEntity1() }
            val json = Gson().toJson(list)
            return Test2(json)
        }

        private fun createRandomEntity1() = JsonEntity1(
                createRandomEntity2List(),
                createRandomEntity2List(),
                createRandomEntity2List(),
                createRandomEntity2List()
        )

        private fun createRandomEntity2List() = List(random.nextInt(10)) {
            createRandomEntity2()
        }


        private fun createRandomEntity2() = JsonEntity2(
                randomString(),
                randomString(),
                randomString(),
                randomString()
        )

        private fun randomString() = UUID.randomUUID().toString()
    }
}