package com.example.saquib.dulhaniyaacom.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.example.saquib.dulhaniyaacom.R;
import com.example.saquib.dulhaniyaacom.adapter.WelcomeAdapter;

import java.util.ArrayList;
import java.util.Arrays;

public class Welcome extends AppCompatActivity {

    // ArrayList for person names
    ArrayList<String> personNames = new ArrayList<>(Arrays.asList("Dulhaniyaa Inpiration", "My Wedding", "Vendors",
            "Dulhaniyaa Partner", "Dulhaniyaa Services", "Social Connect", "My Account", "About Us"));
    ArrayList<Integer> personImages = new ArrayList<>(Arrays.asList(R.drawable.bg1, R.drawable.bg2, R.drawable.bg3,
            R.drawable.yellow_bg, R.drawable.bg1, R.drawable.bg2, R.drawable.bg3, R.drawable.yellow_bg,
            R.drawable.bg1));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager
                (2, LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        WelcomeAdapter customAdapter = new WelcomeAdapter(Welcome.this, personNames, personImages);
        recyclerView.setAdapter(customAdapter);

        recyclerView.setOnClickListener(new View.OnClickListener() {
            // Start new list activity
            public void onClick(View v) {
                Intent mainIntent = new Intent(Welcome.this, DulhaniyaaInspiration.class);
                startActivity(mainIntent);
            }
        });
    }
}