package com.dashlane.benchmarks.json.test1;

import com.google.gson.annotations.SerializedName;

class JsonEntity {
    public static final String A = "cdfa1402-285b-43d4-a90a-1cd04da67b2e";
    public static final String B = "bacc3445-2202-4865-a58d-904f3c7cf01f";
    public static final String C = "7bd608be-7bec-4cf8-a6cd-d5610245ebe3";
    public static final String D = "3af312d7-ff35-4dfe-b296-73803a2d778b";
    public static final String E = "3344c214-0e6e-4af7-9f58-7353c427ed46";
    public static final String F = "e9d51989-da6b-450b-8009-32b17690ddb7";

    @SerializedName(A)
    private String a;
    @SerializedName(B)
    private String b;
    @SerializedName(C)
    private int c;
    @SerializedName(D)
    private int d;
    @SerializedName(E)
    private boolean e;
    @SerializedName(F)
    private boolean f;

    public JsonEntity(String a, String b, int c, int d, boolean e, boolean f) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
    }
}
