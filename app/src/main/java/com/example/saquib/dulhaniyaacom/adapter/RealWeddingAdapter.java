package com.example.saquib.dulhaniyaacom.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidquery.AQuery;
import com.example.saquib.dulhaniyaacom.R;
import com.example.saquib.dulhaniyaacom.activities.RealWeddingDescription;
import com.example.saquib.dulhaniyaacom.bean.RealWeddingResponse;
import com.example.saquib.dulhaniyaacom.fragment.RealWedding;

import java.util.ArrayList;

public class RealWeddingAdapter extends RecyclerView.Adapter<RealWeddingAdapter.MyViewRealWeddingViewHolder> {

private ArrayList<RealWeddingResponse> realWeddingResponseArrayList;
        Context context;
        ArrayList<String> arrayList = new ArrayList<>();
        RealWedding fragment;

public RealWeddingAdapter(Context context, ArrayList<RealWeddingResponse> realWeddingResponseArrayList, RealWedding fragment) {
        this.context = context;
        this.realWeddingResponseArrayList = realWeddingResponseArrayList;
        this.fragment = fragment;
        }

@Override
public MyViewRealWeddingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemview = LayoutInflater.from(parent.getContext()).inflate(R.layout.realwedding_layout, parent, false);
        return new MyViewRealWeddingViewHolder(itemview);
        }

@Override
public void onBindViewHolder(final MyViewRealWeddingViewHolder holder, final int position) {

final RealWeddingResponse realWeddingResponse = realWeddingResponseArrayList.get(position);
        holder.tv_realwedding_title.setText(realWeddingResponseArrayList.get(position).getRwTitle());
        holder.tv_realwedding_description.setText(realWeddingResponseArrayList.get(position).getRwAbout());
        AQuery aQuery = new AQuery(context);
        aQuery.id(holder.iv_realwedding_banner).image(realWeddingResponseArrayList.get(position).getRwImg());

//        if (realWeddingResponse.getStatus().equals("Favourite")) {
//        holder.iv_realwedding_like.setImageDrawable(context.getResources().getDrawable(R.drawable.fav_s));
//        arrayList.add("Favourite");
//        } else if (realWeddingResponse.getStatus().equals("Unfavourite")) {
//        holder.iv_realwedding_like.setImageDrawable(context.getResources().getDrawable(R.drawable.fav_un));
//        arrayList.add("Unfavourite");
//        }

    holder.iv_realwedding_banner.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
        Intent intent = new Intent(context, RealWeddingDescription.class);
        intent.putExtra("image", realWeddingResponseArrayList.get(position).getRwImg());
        intent.putExtra("title", realWeddingResponseArrayList.get(position).getRwTitle());
        intent.putExtra("love", realWeddingResponseArrayList.get(position).getRwLoves());
        intent.putExtra("rw_desc", realWeddingResponseArrayList.get(position).getRwAbout());
        intent.putExtra("rw_id", realWeddingResponseArrayList.get(position).getRwId());
        context.startActivity(intent);
        }
        });
//        holder.iv_realwedding_like.setOnClickListener(new View.OnClickListener() {
//@Override
//public void onClick(View v) {
//        if (arrayList.get(position).equals("Favourite")) {
//        holder.iv_realwedding_like.setImageDrawable(context.getResources().getDrawable(R.drawable.fav_un));
//        arrayList.set(position, "Unfavourite");
//        fragment.callFavouriteApi(realWeddingResponse.getRwId(), "Unfavourite");
//        } else {
//        holder.iv_realwedding_like.setImageDrawable(context.getResources().getDrawable(R.drawable.fav_s));
//        arrayList.set(position, "Favourite");
//        fragment.callFavouriteApi(realWeddingResponse.getRwId(), "Favourite");
//        }
//        }
//        });

        }

@Override
public int getItemCount() {
        return realWeddingResponseArrayList.size();
        }

    public class MyViewRealWeddingViewHolder extends RecyclerView.ViewHolder {

        TextView tv_realwedding_title, tv_realwedding_description;
        ImageView iv_realwedding_banner, iv_realwedding_like;

        public MyViewRealWeddingViewHolder(View itemView) {
            super(itemView);

            tv_realwedding_title = itemView.findViewById(R.id.tv_realwedding_title);
            tv_realwedding_description = itemView.findViewById(R.id.tv_realwedding_description);
            iv_realwedding_banner = itemView.findViewById(R.id.iv_realwedding_banner);
            iv_realwedding_like = itemView.findViewById(R.id.iv_realwedding_like);
        }
    }
}