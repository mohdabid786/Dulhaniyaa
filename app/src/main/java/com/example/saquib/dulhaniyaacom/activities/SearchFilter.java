package com.example.saquib.dulhaniyaacom.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.saquib.dulhaniyaacom.R;
import com.example.saquib.dulhaniyaacom.bean.VendorResponse;

import java.util.ArrayList;

public class SearchFilter extends AppCompatActivity {

    ImageView iv_close, iv_yes;
    TextView food_type;
    Spinner spinner;
    EditText business_name;
    Button reset;
    ArrayList<VendorResponse> arrayList;
    ArrayList<String> spinnerList;
    FilterInterface filterInterface;
    String foodType = "";
    String restName = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        setContentView(R.layout.activity_filter);
        food_type = (TextView) findViewById(R.id.food_type);
        business_name = (EditText) findViewById(R.id.res_name);
        iv_close = (ImageView) findViewById(R.id.iv_close);
        iv_yes = (ImageView) findViewById(R.id.iv_yes);
        reset = (Button) findViewById(R.id.reset);
        spinner = (Spinner) findViewById(R.id.spinner);

        filterInterface = (FilterInterface) Vendor.getFragment();
        spinnerList = new ArrayList<>();
        try {
            arrayList = (ArrayList<VendorResponse>) getIntent().getSerializableExtra("home_arrylist");
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (arrayList != null) {
            for (VendorResponse homeResponse : arrayList) {
//                spinnerList.add(homeResponse.getCat_name());
            }
        }

        ArrayAdapter arrayAdapter = new ArrayAdapter(SearchFilter.this, android.R.layout.simple_list_item_1, spinnerList);
        spinner.setAdapter(arrayAdapter);

        food_type.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spinner.setVisibility(View.VISIBLE);
                spinner.performClick();

            }
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                food_type.setText(parent.getItemAtPosition(position).toString());
                //spinner.setVisibility(View.GONE);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        iv_close.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        iv_yes.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View v) {
                if (validateForm()) {
                    filterInterface.getFilterTypeOrName(food_type.getText().toString(), business_name.getText().toString());
                    finish();
                }
            }
        });

        reset.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View view) {
                //send broadcast
                Intent intent=new Intent("reset");
                intent.putExtra("isReset","yes");
                LocalBroadcastManager.getInstance(SearchFilter.this).sendBroadcast(intent);
                SearchFilter.this.finish();
            }
        });

    }

    public boolean validateForm() {
        boolean validate = true;
        foodType = food_type.getText().toString();
        restName = business_name.getText().toString();
        if (foodType.length() == 0 && restName.length() == 0) {
            Toast.makeText(this, "please enter FOOD TYPE or Restaurant Name", Toast.LENGTH_LONG).show();
            return false;
        }
        return validate;
    }

    public interface FilterInterface {
        public void getFilterTypeOrName(String resType, String resName);
    }
}

