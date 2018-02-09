package com.poc.app.model;


import com.google.gson.annotations.SerializedName;

public class Deal {

    @SerializedName("shortAnnouncementTitle")
    private String shortAnnouncementTitle;

    @SerializedName("mediumImageUrl")
    private String mediumImageUrl;

    @SerializedName("largeImageUrl")
    private String largeImageUrl;

    @SerializedName("merchant")
    private Merchant merchant;

    @SerializedName("pitchHtml")
    private String pitchHtml;

    public String getShortAnnouncementTitle() {
        return shortAnnouncementTitle;
    }

    public String getMediumImageUrl() {
        return mediumImageUrl;
    }

    public String getLargeImageUrl() {
        return largeImageUrl;
    }

    public Merchant getMerchant() {
        return merchant;
    }

    public String getPitchHtml() {
        return pitchHtml;
    }
}
