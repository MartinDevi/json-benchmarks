package com.dashlane.benchmarks.json.test5;

import com.google.gson.annotations.SerializedName;

public class JsonEntity3 {

    public static final String A = "95f39ef1-c986-4a3b-a961-b9e0940b2e94";
    public static final String B = "99d064df-cbd3-47ef-9745-ea363227c4ab";
    public static final String C = "5c9bccdf-25c4-45bb-8924-678bd732f3d2";
    public static final String D = "26c58f81-36e9-471f-92ec-490933d716cb";
    public static final String E = "f86076e7-d226-44a2-83b3-007005170cd7";
    public static final String F = "94bb7fe3-039d-42f4-827a-8814bbfebf3c";
    public static final String G = "a11c3190-dbc3-4d73-9c85-a4c6880c6d1c";

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
    @SerializedName(G)
    private JsonEntity1 g;

    public JsonEntity3(String a, int b, long c, float d, double e, boolean f, JsonEntity1 g) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
    }
}
