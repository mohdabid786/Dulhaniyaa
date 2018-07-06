package com.example.saquib.dulhaniyaacom.adapter;

import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.saquib.dulhaniyaacom.bean.PhotosResponse;
import com.example.saquib.dulhaniyaacom.fragment.Photos;

import java.util.ArrayList;

public class PhotosAdapter extends RecyclerView.Adapter {
    public PhotosAdapter(FragmentActivity activity, ArrayList<PhotosResponse> photosResponseArrayList, Photos photos) {
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
