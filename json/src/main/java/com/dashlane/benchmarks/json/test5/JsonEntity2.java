package com.dashlane.benchmarks.json.test5;

import com.google.gson.annotations.SerializedName;

public class JsonEntity2 {

    public static final String A = "41f2bb67-2dec-4e96-86ba-8281a4637a18";
    public static final String B = "2031b895-66f8-4c9e-9d6f-ab51cc0557c5";
    public static final String C = "3f869870-402b-49e2-b309-dd2d61723437";
    public static final String D = "0c5a8a39-33af-49cf-8063-380d912f7aca";
    public static final String E = "e26f0cb9-eb58-4523-880d-5cd8b1081900";
    public static final String F = "55a37f2a-ad7e-4c02-9aef-b5f69f8dbb20";

    @SerializedName(A)
    private String a;
    @SerializedName(B)
    private int b;
    @SerializedName(C)
    private long c;
    @SerializedName(D)
    private float d;
    @SerializedName(E)
    private double e;
    @SerializedName(F)
    private boolean f;

    public JsonEntity2(String a, int b, long c, float d, double e, boolean f) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
    }
}
