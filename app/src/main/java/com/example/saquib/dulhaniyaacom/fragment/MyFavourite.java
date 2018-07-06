package com.example.saquib.dulhaniyaacom.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.saquib.dulhaniyaacom.R;
import com.example.saquib.dulhaniyaacom.adapter.MYFavAdap;
import com.example.saquib.dulhaniyaacom.bean.CommonResponse;
import com.example.saquib.dulhaniyaacom.bean.MyFavouriteResponse;
import com.example.saquib.dulhaniyaacom.database.SharedPreferenceWriter;
import com.example.saquib.dulhaniyaacom.retrofit.ApiClient;
import com.example.saquib.dulhaniyaacom.retrofit.ApiInterface;
import com.example.saquib.dulhaniyaacom.retrofit.MyDialog;
import com.example.saquib.dulhaniyaacom.util.SharedPreferenceKey;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MyFavourite extends Fragment {

    RecyclerView rv_myfav;
    MYFavAdap myFavAdap;
    List<MyFavouriteResponse> myFavouriteResponseList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_my_fav,container,false);
        rv_myfav= (RecyclerView) view.findViewById(R.id.rv_myfav);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());

        rv_myfav.setLayoutManager(linearLayoutManager);

        callMyFavouriteApi();


        return view;
    }
    private void callMyFavouriteApi()
    {
        MyDialog.getInstance(getActivity()).showDialog();
        Retrofit retrofit = ApiClient.getClient();
        ApiInterface apiInterface=  retrofit.create(ApiInterface.class);
        Call<CommonResponse> call=apiInterface.getMyFavouriteResult( SharedPreferenceWriter.getInstance(getActivity()).getString(SharedPreferenceKey.token));

        call.enqueue(new Callback<CommonResponse>() {
            @Override
            public void onResponse(Call<CommonResponse> call, Response<CommonResponse> response) {
                MyDialog.getInstance(getActivity()).hideDialog();
                if (response.isSuccessful())
                {
                    if (response.body().getStatus().equals("SUCCESS")) {
                        myFavouriteResponseList=response.body().getMyFavourites();
                        if (myFavouriteResponseList.size()>0) {

                            myFavAdap = new MYFavAdap(getActivity(), myFavouriteResponseList,MyFavourite.this);
                            rv_myfav.setAdapter(myFavAdap);
                        }
                        else
                            Toast.makeText(getActivity(),"Data Not Found",Toast.LENGTH_LONG).show();
                    }
                    else
                        Toast.makeText(getActivity(),response.body().getMessage(),Toast.LENGTH_LONG).show();

                }
            }

            @Override
            public void onFailure(Call<CommonResponse> call, Throwable t) {
                MyDialog.getInstance(getActivity()).hideDialog();
            }
        });
    }

    public void callFavouriteApi(String restaurant_id,String rest_type,final int position)
    {
        //MyDialog.getInstance(getActivity()).showDialog();
        Retrofit retrofit = ApiClient.getClient();
        ApiInterface apiInterface=  retrofit.create(ApiInterface.class);
        Call<CommonResponse> call=apiInterface.getFavouriteResult( SharedPreferenceWriter.getInstance(getActivity()).getString(SharedPreferenceKey.token));

        call.enqueue(new Callback<CommonResponse>() {
            @Override
            public void onResponse(Call<CommonResponse> call, Response<CommonResponse> response) {
                //MyDialog.getInstance(getActivity()).hideDialog();
                if (response.isSuccessful())
                {
                    if (response.body().getStatus().equals("SUCCESS")) {
                        myFavouriteResponseList.remove(position);
                        myFavAdap.notifyDataSetChanged();
                        //Toast.makeText(getActivity(),response.body().getMessage(),Toast.LENGTH_LONG).show();

                    }
                    else
                        Toast.makeText(getActivity(),response.body().getMessage(),Toast.LENGTH_LONG).show();

                }
            }

            @Override
            public void onFailure(Call<CommonResponse> call, Throwable t) {
                //MyDialog.getInstance(getActivity()).hideDialog();
            }
        });
    }

}
