package com.example.saquib.dulhaniyaacom.fragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.saquib.dulhaniyaacom.R;
import com.example.saquib.dulhaniyaacom.activities.DulhaniyaaInspiration;
import com.example.saquib.dulhaniyaacom.activities.MainActivity;
import com.example.saquib.dulhaniyaacom.activities.Notification;
import com.example.saquib.dulhaniyaacom.adapter.BlogAdapter;
import com.example.saquib.dulhaniyaacom.bean.BlogResponse;
import com.example.saquib.dulhaniyaacom.bean.CommonResponse;
import com.example.saquib.dulhaniyaacom.database.SharedPreferenceWriter;
import com.example.saquib.dulhaniyaacom.retrofit.ApiClient;
import com.example.saquib.dulhaniyaacom.retrofit.ApiInterface;
import com.example.saquib.dulhaniyaacom.retrofit.MyDialog;
import com.example.saquib.dulhaniyaacom.util.GPSTracker;
import com.example.saquib.dulhaniyaacom.util.SharedPreferenceKey;
import com.github.siyamed.shapeimageview.mask.PorterShapeImageView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import static com.example.saquib.dulhaniyaacom.R.id.rv_blog;
import static com.example.saquib.dulhaniyaacom.R.id.rv_blog_desc;

public class Blogs extends Fragment {

    View view;
    private RecyclerView rv_blog;
    private BlogAdapter blogAdapter;
    ArrayList<BlogResponse> blogResponseArrayList;
    ArrayList<BlogResponse> blogResponseArrayListClone;
    ArrayList<BlogResponse> arrayList;
    BlogInterface blogInterface;
    ArrayList<BlogResponse> blogList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blogs, container, false);

    }

    private void registerLocalBroadcastManager() {
        LocalBroadcastManager.getInstance(DulhaniyaaInspiration.instance).registerReceiver(broadcastReceiver, new IntentFilter("reset"));
    }

    private void unRegisterBroadcastmanager() {
        LocalBroadcastManager.getInstance(DulhaniyaaInspiration.instance).unregisterReceiver(broadcastReceiver);
    }

    BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String isReset = intent.getStringExtra("isReset");
            if (isReset.equals("yes")) {
                callBlogApi();
            }
        }
    };

    @Override
    public void onDestroy() {
        super.onDestroy();
        unRegisterBroadcastmanager();
    }

    private void All_ID() {

        rv_blog = view.findViewById(R.id.rv_blog);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        rv_blog.setLayoutManager(linearLayoutManager);
    }


    @Override
    public void onCreateOptionsMenu(
            Menu menu, MenuInflater inflater) {

        inflater.inflate(R.menu.notification, menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle item selection
        switch (item.getItemId()) {
            case R.id.not_menu:

                Intent intent = new Intent(getContext(), Notification.class);
                startActivity(intent);

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

//    @Override
//    public void getFilterTypeOrName(String blog_title, String blog_desc) {
//        blogList = new ArrayList<>();
//        blogResponseArrayList.clear();
//        blogResponseArrayList.addAll(blogResponseArrayListClone);
//        for (BlogResponse blogResponse : blogResponseArrayList) {
//
//            if ((blogResponse.getBlog_title().contains(blog_title.trim()) && blog_title.trim().length() > 0) || (blogResponse.getBlog_desc().contains(blog_desc.trim()) && blog_desc.trim().length() > 0)) {
//                BlogResponse blogResponse1 = new BlogResponse();
//                blogResponse1.setBlog_img(blogResponse.getBlog_img());
//                blogResponse1.setBlog_love(blogResponse.getBlog_love());
//                blogResponse1.setBlog_id(blogResponse.getBlog_id());
//                blogResponse1.setStatus(blogResponse.getStatus());
//                blogList.add(blogResponse1);
//            }
//
//        }
//        blogResponseArrayList.clear();
//        blogResponseArrayList.addAll(blogList);
//        blogAdapter.notifyDataSetChanged();
//    }

    private void callBlogApi() {
        MyDialog.getInstance(getActivity()).showDialog();
        Retrofit retrofit = ApiClient.getClient();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        Call<CommonResponse> call = apiInterface.getBlogResult(SharedPreferenceWriter.getInstance(getActivity()).getString(SharedPreferenceKey.token));

        call.enqueue(new Callback<CommonResponse>() {
            @Override
            public void onResponse(Call<CommonResponse> call, Response<CommonResponse> response) {
                MyDialog.getInstance(getActivity()).hideDialog();
                if (response.isSuccessful()) {
                    if (response.body().getStatus().equals("SUCCESS")) {
                        //here,we get all the response of Home api.using getter method,like getHome(),we got the response.here response is comeing in array form,so to store this we take arraylist type variable which is globally declared above
                        blogResponseArrayList = (ArrayList<BlogResponse>) response.body().getBlog();

                        blogResponseArrayListClone = new ArrayList<BlogResponse>();
                        arrayList = new ArrayList<>();
                        blogResponseArrayListClone.addAll(blogResponseArrayList);
                        arrayList.addAll(blogResponseArrayListClone);

                        //
                        blogInterface.getBlogList(arrayList);

                        //here response is comeing in List form,so to store homeResponseArrayList,we declare homeResponseArrayList as blank list like  ArrayList<HomeResponse> homeResponseArrayList;
                        //to call HomeAdapter on Home Fragment using constructor made in HomeAdapter class
                        blogAdapter = new BlogAdapter(getActivity(), blogResponseArrayList, Blogs.this);
                        // Attach the adapter to a recyclerview
                        rv_blog.setAdapter(blogAdapter);//on recyclerview we set the adapter.

                    } else {
                        Toast.makeText(getActivity(), response.body().getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<CommonResponse> call, Throwable t) {
                MyDialog.getInstance(getActivity()).hideDialog();
            }
        });
    }

    public void callFavouriteApi(String blog_id) {
        //MyDialog.getInstance(getActivity()).showDialog();
        Retrofit retrofit = ApiClient.getClient();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        Call<CommonResponse> call = apiInterface.getFavouriteResult(SharedPreferenceWriter.getInstance(getActivity()).getString(SharedPreferenceKey.token));

        call.enqueue(new Callback<CommonResponse>() {
            @Override
            public void onResponse(Call<CommonResponse> call, Response<CommonResponse> response) {
                //MyDialog.getInstance(getActivity()).hideDialog();
                if (response.isSuccessful()) {
                    if (response.body().getStatus().equals("SUCCESS")) {
                        //myFavAdap.notifyDataSetChanged();
                        //Toast.makeText(getActivity(),response.body().getMessage(),Toast.LENGTH_LONG).show();

                    } else
                        Toast.makeText(getActivity(), response.body().getMessage(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<CommonResponse> call, Throwable t) {
                //MyDialog.getInstance(getActivity()).hideDialog();
            }
        });
    }

    public interface BlogInterface {
        public void getBlogList(ArrayList<BlogResponse> blogResponseArrayList);
    }
}
