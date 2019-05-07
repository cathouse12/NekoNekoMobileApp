package com.nekoneko.ni;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class NekoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final String TAG = "NekoAdapter";

    ArrayList<NekoItem> mNekoItems = new ArrayList<>();

    public static class NekoHolder extends RecyclerView.ViewHolder{
        TextView mNameTextVIew;
        TextView mFeedTextView;
        TextView mWaterTextView;

        public NekoHolder(View view) {
            super(view);
            mNameTextVIew = view.findViewById(R.id.mNameTextView);
            mFeedTextView = view.findViewById(R.id.mFeedTextView);
            mWaterTextView = view.findViewById(R.id.mWaterTextView);
        }
    }

    

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int position) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_neko,parent,false);
        return new NekoAdapter.NekoHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        NekoAdapter.NekoHolder nekoHolder = (NekoAdapter.NekoHolder) holder;

        nekoHolder.mNameTextVIew.setText(mNekoItems.get(position).getmName());
        nekoHolder.mFeedTextView.setText(mNekoItems.get(position).getmFeedQuantity());
        nekoHolder.mWaterTextView.setText(mNekoItems.get(position).getmWaterQuantity());
    }

    @Override
    public int getItemCount() {
        return mNekoItems.size();
    }
}
