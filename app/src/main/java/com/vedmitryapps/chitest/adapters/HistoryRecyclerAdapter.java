package com.vedmitryapps.chitest.adapters;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vedmitryapps.chitest.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HistoryRecyclerAdapter extends RecyclerView.Adapter<HistoryRecyclerAdapter.ViewHolder> {

    List<String> times;

    public HistoryRecyclerAdapter(List<String> times) {
        this.times = times;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_history_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.textView.setText(position + 1 + ". " + times.get(position));
    }

    @Override
    public int getItemCount() {
        return times.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.time)
        TextView textView;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
