package com.poc.app.dagger;

import com.poc.app.base.BaseView;
import com.poc.app.model.Deal;

import java.util.List;


public interface HomeContract {

    interface View extends BaseView {
        void initializeList(List<Deal> items);

        void setLoaderVisibility(boolean isVisible);

        void itemInfo(Deal item);

        void setNoDataVisibility(boolean isVisible);

        void setItemsVisibility(boolean isVisible);

    }


    interface Presenter {
        void getList();

        void unSubscribe();

        RecyclerItemListener getRecyclerItemListener();
    }
}
