package com.dashlane.benchmarks.json.test2;

import com.google.gson.annotations.SerializedName;

import java.util.List;

class JsonEntity1 {
    public static final String A = "98950a44-b34c-4833-a635-371b7300ea19";
    public static final String B = "eb8fbfcf-23ad-41c0-a473-57179aa368b5";
    public static final String C = "66823d7d-d75e-4eb5-8045-5b8de0b26d80";
    public static final String D = "99fd8852-75dc-49e8-8fed-2de55912b82a";

    @SerializedName(A)
    private List<JsonEntity2> a;
    @SerializedName(B)
    private List<JsonEntity2> b;
    @SerializedName(C)
    private List<JsonEntity2> c;
    @SerializedName(D)
    private List<JsonEntity2> d;

    public JsonEntity1(List<JsonEntity2> a, List<JsonEntity2> b, List<JsonEntity2> c, List<JsonEntity2> d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
}
