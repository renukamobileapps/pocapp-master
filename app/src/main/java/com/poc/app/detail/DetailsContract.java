package com.poc.app.detail;


import com.poc.app.base.BaseView;
import com.poc.app.model.Deal;

public interface DetailsContract extends BaseView {
    interface View extends BaseView {
        void initializeView(Deal item);
    }

    interface Presenter {
        String getMainImageURL();
    }
}
