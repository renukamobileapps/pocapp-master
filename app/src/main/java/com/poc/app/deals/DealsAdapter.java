package com.poc.app.deals;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.poc.app.R;
import com.poc.app.dagger.RecyclerItemListener;
import com.poc.app.model.Deal;


import java.util.List;

public class DealsAdapter extends RecyclerView.Adapter<DealsViewHolder> {
    private final List<Deal> deals;
    private RecyclerItemListener onItemClickListener;

    public DealsAdapter(RecyclerItemListener onItemClickListener, List<Deal> news) {
        this.onItemClickListener = onItemClickListener;
        this.deals = news;
    }

    @Override
    public DealsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.deal_item, parent, false);
        return new DealsViewHolder(view, onItemClickListener);
    }

    @Override
    public void onBindViewHolder(DealsViewHolder holder, int position) {
        holder.bind(position, deals.get(position), onItemClickListener);
    }

    @Override
    public int getItemCount() {
        return deals.size();
    }
}

