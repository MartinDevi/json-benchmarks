package com.dashlane.benchmarks.json.test2;

import com.google.gson.annotations.SerializedName;

class JsonEntity2 {

    public static final String A = "1379ab89-d2f0-46b6-9f01-864ca4bd295d";
    public static final String B = "b4b0af77-99e6-422f-84aa-2377775b61c1";
    public static final String C = "81c9b5ef-934e-4fa1-b91c-33015533a96e";
    public static final String D = "dc36085d-b155-40e7-8147-1327f0242d94";

    @SerializedName(A)
    private String a;
    @SerializedName(B)
    private String b;
    @SerializedName(C)
    private String c;
    @SerializedName(D)
    private String d;

    public JsonEntity2(String a, String b, String c, String d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
}
