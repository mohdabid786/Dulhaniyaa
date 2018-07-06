package com.example.saquib.dulhaniyaacom.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.EventLogTags;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidquery.AQuery;
import com.example.saquib.dulhaniyaacom.R;
import com.example.saquib.dulhaniyaacom.activities.BlogDescription;
import com.example.saquib.dulhaniyaacom.bean.BlogResponse;
import com.example.saquib.dulhaniyaacom.fragment.Blogs;

import java.util.ArrayList;

public class BlogAdapter extends RecyclerView.Adapter<BlogAdapter.MyViewBlogViewHolder> {

    private ArrayList<BlogResponse> blogResponseArrayList;
    Context context;
    ArrayList<String> arrayList = new ArrayList<>();
    Blogs fragment;

    public BlogAdapter(Context context, ArrayList<BlogResponse> homeResponseArrayList, Blogs fragment) {
        this.context = context;
        this.blogResponseArrayList = homeResponseArrayList;
        this.fragment = fragment;
    }

    @Override
    public MyViewBlogViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemview = LayoutInflater.from(parent.getContext()).inflate(R.layout.blog_layout, parent, false);
        return new MyViewBlogViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(final MyViewBlogViewHolder holder, final int position) {

        final BlogResponse homeResponse = blogResponseArrayList.get(position);
        holder.blog_title.setText(blogResponseArrayList.get(position).getBlogTitle());
        holder.blog_desc.setText(blogResponseArrayList.get(position).getBlogDesc());
        AQuery aQuery = new AQuery(context);
        aQuery.id(holder.blog_img).image(blogResponseArrayList.get(position).getBlogImg(), false, false, 0, R.drawable.webcover1);

//        if (homeResponse.getStatus().equals("Favourite")) {
//            holder.blog_like.setImageDrawable(context.getResources().getDrawable(R.drawable.fav_s));
//            arrayList.add("Favourite");
//        } else if (homeResponse.getStatus().equals("Unfavourite")) {
//            holder.blog_like.setImageDrawable(context.getResources().getDrawable(R.drawable.fav_un));
//            arrayList.add("Unfavourite");
//        }

        holder.blog_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, BlogDescription.class);
                intent.putExtra("blog_img", blogResponseArrayList.get(position).getBlogImg());
                intent.putExtra("blog_title", blogResponseArrayList.get(position).getBlogTitle());
                intent.putExtra("blog_desc", blogResponseArrayList.get(position).getBlogDate());
                intent.putExtra("blog_love", blogResponseArrayList.get(position).getBlogLove());
                intent.putExtra("blog_id", blogResponseArrayList.get(position).getBlogId());
                context.startActivity(intent);
            }
        });
//        holder.blog_like.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (arrayList.get(position).equals("Favourite")) {
//                    holder.blog_like.setImageDrawable(context.getResources().getDrawable(R.drawable.fav_un));
//                    arrayList.set(position, "Unfavourite");
//                    fragment.callFavouriteApi(homeResponse.getBlog_id(), "Unfavourite");
//                } else {
//                    holder.blog_like.setImageDrawable(context.getResources().getDrawable(R.drawable.fav_s));
//                    arrayList.set(position, "Favourite");
//                    fragment.callFavouriteApi(homeResponse.getBlog_id(), "Favourite");
//                }
//            }
//        });

    }

    @Override
    public int getItemCount() {
        return blogResponseArrayList.size();
    }

    public class MyViewBlogViewHolder extends RecyclerView.ViewHolder {

        TextView blog_title, blog_desc;
        ImageView blog_img, blog_like;

        public MyViewBlogViewHolder(View itemView) {
            super(itemView);

            blog_title = itemView.findViewById(R.id.blog_title);
            blog_desc = itemView.findViewById(R.id.blog_desc);
            blog_img = itemView.findViewById(R.id.blog_img);
            blog_like = itemView.findViewById(R.id.iv_like);
        }
    }
}
