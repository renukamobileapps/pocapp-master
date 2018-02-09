package com.poc.app;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.poc.app.base.BaseActivity;
import com.poc.app.dagger.HomeContract;
import com.poc.app.dagger.HomePresenter;
import com.poc.app.deals.DealsAdapter;
import com.poc.app.detail.DetailsActivity;
import com.poc.app.model.Deal;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

public class MainActivity extends BaseActivity implements HomeContract.View{

    @Inject
    HomePresenter presenter;


    @BindView(R.id.rv_list)
    RecyclerView rvList;

    @BindView(R.id.pb_loading)
    ProgressBar pbLoading;

    @BindView(R.id.tv_no_data)
    TextView tvNoData;

    @BindView(R.id.rl_list)
    RelativeLayout rlList;



    @Override
    protected void initializeDagger() {
        PocApp app = (PocApp) getApplicationContext();
        app.getMainComponent().inject(MainActivity.this);
    }

    @Override
    protected void initializePresenter() {
        super.presenter=presenter;
        presenter.setView(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }


    @Override
    public void initializeList(List<Deal> items) {
        DealsAdapter newsAdapter = new DealsAdapter(presenter.getRecyclerItemListener(), items);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rvList.setLayoutManager(layoutManager);
        rvList.setHasFixedSize(true);
        rvList.setAdapter(newsAdapter);
    }

    @Override
    public void setLoaderVisibility(boolean isVisible) {
        pbLoading.setVisibility(isVisible ? VISIBLE : GONE);
    }

    @Override
    public void itemInfo(Deal item) {

        AppSingleton.getInstance().setSelectedDeal(item);
        startActivity(new Intent(getApplicationContext(), DetailsActivity.class));
    }

    @Override
    public void setNoDataVisibility(boolean isVisible) {
        tvNoData.setVisibility(isVisible ? VISIBLE : GONE);
    }

    @Override
    public void setItemsVisibility(boolean isVisible) {
        rlList.setVisibility(isVisible ? VISIBLE : GONE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.unSubscribe();
    }
}
