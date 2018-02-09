package com.poc.app.detail;

import android.os.Bundle;


import com.poc.app.AppSingleton;
import com.poc.app.dagger.Presenter;
import com.poc.app.model.Deal;

import javax.inject.Inject;


public class DetailsPresenter extends Presenter<DetailsContract.View> implements DetailsContract.Presenter {

    Deal item;

    @Inject
    public DetailsPresenter() {
    }

    @Override
    public void initialize(Bundle extras) {
        super.initialize(extras);
        getView().initializeView(AppSingleton.getInstance().getSelectedDeal());
    }

    @Override
    public String getMainImageURL() {

        return null;
    }
}
