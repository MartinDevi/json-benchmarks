package com.dashlane.benchmarks.json.test3;


import com.google.gson.annotations.SerializedName;

class JsonEntity {

    public static final String A = "4b8f9c82-3292-4e86-8163-6f7d49eb5a7a";
    public static final String B = "c1644bf5-b3fc-42d3-9b9e-d9fef7e2972d";
    public static final String C = "4f4862f2-e236-4748-9288-c0f2461e29c8";
    public static final String D = "7a493ff6-c451-437f-bf94-9a11c1b7bff7";

    @SerializedName(A)
    private JsonEntity a;
    @SerializedName(B)
    private JsonEntity b;
    @SerializedName(C)
    private JsonEntity c;
    @SerializedName(D)
    private JsonEntity d;

    public JsonEntity(JsonEntity a, JsonEntity b, JsonEntity c, JsonEntity d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
}
