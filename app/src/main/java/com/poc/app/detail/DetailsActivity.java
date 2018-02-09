package com.poc.app.detail;

import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;

import com.poc.app.base.BaseActivity;
import com.poc.app.PocApp;
import com.poc.app.R;
import com.poc.app.model.Deal;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import butterknife.BindView;

public class DetailsActivity extends BaseActivity implements DetailsContract.View {

    @Inject
    DetailsPresenter presenter;

    @BindView(R.id.tv_title)
    TextView tvTitle;

    @BindView(R.id.iv_main_Image)
    ImageView ivMainImage;

    @BindView(R.id.tv_description)
    TextView tvDescription;

    @Override
    protected void initializeDagger() {
        PocApp app = (PocApp) getApplicationContext();
        app.getMainComponent().inject(DetailsActivity.this);
    }

    @Override
    protected void initializePresenter() {
        super.presenter = presenter;
        presenter.setView(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.details_layout;
    }


    @Override
    public void initializeView(Deal item) {
        tvTitle.setText(item.getShortAnnouncementTitle());
        tvDescription.setText(Html.fromHtml(item.getPitchHtml()));
       Picasso.with(this).load(item.getLargeImageUrl()).into(ivMainImage);;
    }
}
