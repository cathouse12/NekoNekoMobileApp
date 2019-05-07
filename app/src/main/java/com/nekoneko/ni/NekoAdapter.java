package com.nekoneko.ni;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class NekoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final String TAG = "NekoAdapter";

    ArrayList<NekoItem> mNekoItems = new ArrayList<>();

    public static class NekoHolder extends RecyclerView.ViewHolder{


        public NekoHolder(View view) {
            super(view);

        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int position) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.)
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        NekoAdapter.
    }

    @Override
    public int getItemCount() {
        return mNekoItems.size();
    }
}
