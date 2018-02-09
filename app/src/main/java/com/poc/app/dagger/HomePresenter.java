package com.poc.app.dagger;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;


import com.google.gson.Gson;
import com.poc.app.model.Deal;
import com.poc.app.retrofit.ApiInterface;
import com.poc.app.retrofit.ApiUtil;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.poc.app.PocApp.getContext;


public class HomePresenter extends Presenter<HomeContract.View> implements HomeContract.Presenter {


    private List<Deal> deals;

    @Inject
    public HomePresenter() {

    }

    @Override
    public void initialize(Bundle extras) {
        super.initialize(extras);
        getList();
    }

    @Override
    public void getList() {
        getView().setLoaderVisibility(true);
        getView().setNoDataVisibility(false);
        getView().setItemsVisibility(false);

        Call call;
        ApiInterface apiService = ApiUtil.getClient().create(ApiInterface.class);
        call = apiService.getDeals();
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                int statusCode = response.code();

                if (response.isSuccessful()) {
                    try {
                       deals = new ArrayList<>();
                        String a = new Gson().toJson(response.body());

                        JSONObject jObjRes = new JSONObject(a);
                        JSONArray jObjcontacts = jObjRes.getJSONArray("deals");

                        for (int i = 0; i < jObjcontacts.length(); i++) {
                            if (jObjcontacts.get(i) instanceof JSONObject) {
                                JSONObject jsnObj = (JSONObject) jObjcontacts.get(i);
                                Deal obj = new Gson().fromJson(jsnObj.toString(), Deal.class);
                                deals.add(obj);
                            }
                        }

                        getView().setLoaderVisibility(false);
                        getView().setNoDataVisibility(false);
                        getView().setItemsVisibility(true);
                        getView().initializeList(deals);

                    } catch (Exception e) {
                        Log.e("error", e.getMessage());

                        Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                        getView().setLoaderVisibility(false);
                        getView().setNoDataVisibility(true);
                        getView().setItemsVisibility(false);
                    }

                } else {
                    getView().setLoaderVisibility(false);
                    getView().setNoDataVisibility(true);
                    getView().setItemsVisibility(false);
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                // Log error here since request failed
                Log.e("error message", t.toString());

                getView().setLoaderVisibility(false);
                getView().setNoDataVisibility(true);
                getView().setItemsVisibility(false);
            }
        });

    }

    @Override
    public void unSubscribe() {

    }

    @Override
    public RecyclerItemListener getRecyclerItemListener() {
        return recyclerItemListener;
    }

    private final RecyclerItemListener recyclerItemListener = position -> {
        getView().itemInfo(deals.get(position));
    };
}
