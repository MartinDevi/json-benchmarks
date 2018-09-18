package com.dashlane.benchmarks.json.test4;

import com.google.gson.annotations.SerializedName;

import java.util.List;

class JsonEntity {

    public static final String A = "b9844e7e-975d-4423-82b8-8d87ec3501e6";
    public static final String B = "7a268c85-c4fd-44b4-bb92-e4c9c8f156dd";
    public static final String C = "3e0bf73c-573c-45f5-9af5-9d9e07d57907";
    public static final String D = "d3d94edd-258c-4c04-b00c-e032e4f4355d";

    @SerializedName(A)
    private List<JsonEntity> a;
    @SerializedName(B)
    private List<JsonEntity> b;
    @SerializedName(C)
    private List<JsonEntity> c;
    @SerializedName(D)
    private List<JsonEntity> d;

    public JsonEntity(List<JsonEntity> a, List<JsonEntity> b, List<JsonEntity> c, List<JsonEntity> d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
}
