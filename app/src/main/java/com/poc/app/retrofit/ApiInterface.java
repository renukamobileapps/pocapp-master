package com.poc.app.retrofit;

import com.google.gson.JsonObject;
import com.poc.app.model.Deal;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;


public interface ApiInterface {
    @GET("deals.json?tsToken=US_AFF_0_201236_212556_0&limit=30")
    Call<Object> getDeals();

}
