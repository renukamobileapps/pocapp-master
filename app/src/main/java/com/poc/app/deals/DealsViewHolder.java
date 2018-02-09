package com.poc.app.deals;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.poc.app.R;
import com.poc.app.dagger.RecyclerItemListener;
import com.poc.app.model.Deal;
import com.squareup.picasso.Picasso;


import butterknife.BindView;
import butterknife.ButterKnife;

import static android.text.TextUtils.isEmpty;

public class DealsViewHolder extends RecyclerView.ViewHolder {

    private RecyclerItemListener onItemClickListener;

    @BindView(R.id.tv_caption)
    TextView tvCaption;

    @BindView(R.id.tv_title)
    TextView tvTitle;

    @BindView(R.id.rl_item)
    RelativeLayout itemLayout;

    @BindView(R.id.iv_item_image)
    ImageView itemImage;


    public DealsViewHolder(View itemView, RecyclerItemListener onItemClickListener) {
        super(itemView);
        this.onItemClickListener = onItemClickListener;
        ButterKnife.bind(this, itemView);
    }

    public void bind(final int position, Deal item,final RecyclerItemListener recyclerItemListener) {

            tvTitle.setText(item.getShortAnnouncementTitle());
            tvCaption.setText(item.getMerchant().getName());


        Picasso.with(itemImage.getContext()).load(item.getMediumImageUrl()).into(itemImage);
        itemLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerItemListener.onItemSelected(position);
            }
        });
    }
}

