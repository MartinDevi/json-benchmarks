package com.dashlane.benchmarks.json.test5;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class JsonEntity1 {

    public static final String A = "d8a3250b-ad47-4592-9c9b-a54a030b5d6d";
    public static final String B = "0e5284ef-b9a9-414b-9790-beeb32bb0030";
    public static final String C = "cd2a573a-6e50-4662-8498-cbf2ed7b2e24";
    public static final String D = "eae634f9-0f61-476e-8889-1b35900077b6";
    public static final String E = "c722704f-c35f-4583-bfda-4c31635c4072";
    public static final String F = "185eeda1-9446-4af0-977d-c254a78d4f5c";
    public static final String G = "c2b9f9b0-ab44-41e1-a242-8e58b16ccd40";
    public static final String H = "ac8eda03-77c9-4bfc-b92d-4c25ce26807c";

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
    private JsonEntity2 g;
    @SerializedName(H)
    private List<JsonEntity3> h;

    public JsonEntity1(String a, int b, long c, float d, double e, boolean f, JsonEntity2 g, List<JsonEntity3> h) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
        this.h = h;
    }
}
