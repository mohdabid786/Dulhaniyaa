package com.example.saquib.dulhaniyaacom.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.FailReason;

import com.androidquery.AQuery;
import com.example.saquib.dulhaniyaacom.R;
import com.example.saquib.dulhaniyaacom.activities.VendorDescription;
import com.example.saquib.dulhaniyaacom.activities.Vendor;
import com.example.saquib.dulhaniyaacom.bean.VendorResponse;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

import java.util.ArrayList;
import java.util.List;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

public class VendorAdapter extends ArrayAdapter {

    private List<VendorResponse> movieModelList;
    private int resource;
    private LayoutInflater inflater;
    public VendorAdapter(Context context, int resource, List<VendorResponse> objects) {
        super(context, resource, objects);
        movieModelList = objects;
        this.resource = resource;
        inflater = (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;

        if(convertView == null){
            holder = new ViewHolder();
            convertView = inflater.inflate(resource, null);
            holder.cat_banner = convertView.findViewById(R.id.cat_banner);
            holder.cat_icon = convertView.findViewById(R.id.cat_icon);
            holder.cat_name = convertView.findViewById(R.id.cat_name);
            holder.count = convertView.findViewById(R.id.results);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        final ProgressBar progressBar = (ProgressBar)convertView.findViewById(R.id.progressBar);

        // Then later, when you want to display image
        final ViewHolder finalHolder = holder;
        ImageLoader.getInstance().displayImage(movieModelList.get(position).getCatBanner(), holder.cat_banner, new ImageLoadingListener() {
            @Override
            public void onLoadingStarted(String imageUri, View view) {
                progressBar.setVisibility(View.VISIBLE);
                finalHolder.cat_banner.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
                progressBar.setVisibility(View.GONE);
                finalHolder.cat_banner.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                progressBar.setVisibility(View.GONE);
                finalHolder.cat_banner.setVisibility(View.VISIBLE);
            }

            @Override
            public void onLoadingCancelled(String imageUri, View view) {
                progressBar.setVisibility(View.GONE);
                finalHolder.cat_banner.setVisibility(View.INVISIBLE);
            }
        });

        ImageLoader.getInstance().displayImage(movieModelList.get(position).getCatBanner(), holder.cat_icon, new ImageLoadingListener() {
            @Override
            public void onLoadingStarted(String imageUri, View view) {
                progressBar.setVisibility(View.VISIBLE);
                finalHolder.cat_icon.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
                progressBar.setVisibility(View.GONE);
                finalHolder.cat_icon.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                progressBar.setVisibility(View.GONE);
                finalHolder.cat_icon.setVisibility(View.VISIBLE);
            }

            @Override
            public void onLoadingCancelled(String imageUri, View view) {
                progressBar.setVisibility(View.GONE);
                finalHolder.cat_icon.setVisibility(View.INVISIBLE);
            }
        });

        holder.cat_name.setText(movieModelList.get(position).getCatName());
        holder.count.setText(movieModelList.get(position).getCount() +" "+ "results");
        return convertView;
    }


    class ViewHolder{
        private ImageView cat_banner;
        private ImageView cat_icon;
        private TextView cat_name;
        private  TextView count;
    }

}