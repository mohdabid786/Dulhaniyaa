package com.example.saquib.dulhaniyaacom.fragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.LocalBroadcastManager;
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
import com.example.saquib.dulhaniyaacom.activities.Notification;
import com.example.saquib.dulhaniyaacom.adapter.RealWeddingAdapter;
import com.example.saquib.dulhaniyaacom.bean.CommonResponse;
import com.example.saquib.dulhaniyaacom.bean.RealWeddingResponse;
import com.example.saquib.dulhaniyaacom.database.SharedPreferenceWriter;
import com.example.saquib.dulhaniyaacom.retrofit.ApiClient;
import com.example.saquib.dulhaniyaacom.retrofit.ApiInterface;
import com.example.saquib.dulhaniyaacom.retrofit.MyDialog;
import com.example.saquib.dulhaniyaacom.util.GPSTracker;
import com.example.saquib.dulhaniyaacom.util.SharedPreferenceKey;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class RealWedding extends Fragment {

    View view;
    private RecyclerView rv_realwedding;
    GPSTracker gpsTracker;
    private RealWeddingAdapter realWeddingAdapter;
    ArrayList<RealWeddingResponse> realWeddingResponseArrayList;
    ArrayList<RealWeddingResponse> realWeddingResponseArrayListClone;
    ArrayList<RealWeddingResponse> arrayList;
    ArrayList<RealWeddingResponse> realWeddingList;

    public RealWedding() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_real_wedding, container, false);


    }
}
