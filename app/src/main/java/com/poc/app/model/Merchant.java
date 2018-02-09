package com.poc.app.model;


import com.google.gson.annotations.SerializedName;

public class Merchant {

    @SerializedName("id")
    private String id;

    @SerializedName("name")
    private String name;

    @SerializedName("websiteUrl")
    private String websiteUrl;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }
}
