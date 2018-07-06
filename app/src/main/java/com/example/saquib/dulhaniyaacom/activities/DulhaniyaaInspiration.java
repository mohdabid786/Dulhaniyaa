package com.example.saquib.dulhaniyaacom.activities;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.saquib.dulhaniyaacom.R;
import com.example.saquib.dulhaniyaacom.bean.BlogResponse;
import com.example.saquib.dulhaniyaacom.bean.PhotosResponse;
import com.example.saquib.dulhaniyaacom.database.SharedPreferenceWriter;
import com.example.saquib.dulhaniyaacom.fragment.Blogs;
import com.example.saquib.dulhaniyaacom.fragment.Photos;
import com.example.saquib.dulhaniyaacom.fragment.RealWedding;
import com.example.saquib.dulhaniyaacom.util.BottomNavigationViewHelper;
import com.example.saquib.dulhaniyaacom.util.DulhaniyaaApplication;
import com.example.saquib.dulhaniyaacom.util.GPSTracker;
import com.example.saquib.dulhaniyaacom.util.SharedPreferenceKey;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class DulhaniyaaInspiration extends AppCompatActivity {

    BottomNavigationView navigation;
    TextView tv_title;
    private Toolbar myToolbar;
    TextView tool_text;
    String fcm_type = "", fcm_message = "";
    public static boolean openApp = false;
    ArrayList<BlogResponse> blogResponseArrayList;

    public static Fragment getFragment() {
        return fragment;
    }

    public static void setFragment(Fragment fragment) {
        DulhaniyaaInspiration.fragment = fragment;
    }

    static Fragment fragment;
    public static DulhaniyaaInspiration instance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dulhaniyaa_inspiration);


        // blogResponseArrayList=new ArrayList<>();
        instance=this;
        SharedPreferenceWriter.getInstance(this).writeBooleanValue(SharedPreferenceKey.appOpenOrNOt, true);
        openApp = true;

        /*LocalBroadcastManager.getInstance(this.getApplicationContext()).registerReceiver(messageReciever,
                new IntentFilter("Push"));*/
//        try {
//            fcm_type = getIntent().getStringExtra("type");
//            fcm_message = getIntent().getStringExtra("message");
//            if (!fcm_message.equals(""))
//                Toast.makeText(this, fcm_message, Toast.LENGTH_LONG).show();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        All(lat, log);

    }

    public Fragment getVisibleFragment() {
        FragmentManager fragmentManager = DulhaniyaaInspiration.this.getSupportFragmentManager();
        @SuppressLint("RestrictedApi") List<Fragment> fragments = fragmentManager.getFragments();
        if (fragments != null) {
            for (Fragment fragment : fragments) {
                if (fragment != null && fragment.isVisible())
                    return fragment;
            }
        }
        return null;
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @SuppressLint("ResourceType")
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {

                case R.id.photos:
                    if (android.os.Build.VERSION.SDK_INT >= 21) {
                        Window window = getWindow();
                        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                        window.setStatusBarColor(getResources().getColor(R.color.colorAccent));
                    }
                    getSupportActionBar().show();
                    tv_title.setVisibility(View.VISIBLE);
                    tv_title.setText("Dulhaniyaa Inspiration");

//                    img_homeLogo.setVisibility(View.VISIBLE);
                    tool_text.setVisibility(View.VISIBLE);
//                    tv_title.setVisibility(View.GONE);

                    setToolbarBackground(true);

                    Fragment photos = new Photos();
                    setFragment(fragment);

                    getSupportFragmentManager().beginTransaction().replace(R.id.content, fragment).commit();
                    myToolbar.setNavigationIcon(R.drawable.filter_home);

                    myToolbar.setNavigationOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            Intent intent = new Intent(DulhaniyaaInspiration.this, RealWedding.class);
                            intent.putExtra("blog_arrylist",blogResponseArrayList);
                            startActivity(intent);
                        }
                    });
                    return true;

                case R.id.real_wedding:
                    if (android.os.Build.VERSION.SDK_INT >= 21) {
                        Window window = getWindow();
                        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                        window.setStatusBarColor(getResources().getColor(R.color.colorAccent));
                    }
                    getSupportActionBar().show();
                    tv_title.setVisibility(View.VISIBLE);
                    tv_title.setText("Dulhaniyaa Inspiration");

//                    img_homeLogo.setVisibility(View.VISIBLE);
                    tool_text.setVisibility(View.VISIBLE);
//                    tv_title.setVisibility(View.GONE);

                    setToolbarBackground(true);

                    Fragment realWedding = new RealWedding();
                    setFragment(fragment);

                    getSupportFragmentManager().beginTransaction().replace(R.id.content, fragment).commit();
                    myToolbar.setNavigationIcon(R.drawable.filter_home);

                    myToolbar.setNavigationOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            Intent intent = new Intent(DulhaniyaaInspiration.this, RealWedding.class);
                            intent.putExtra("home_arrylist",blogResponseArrayList);
                            startActivity(intent);
                        }
                    });
                    return true;

                case R.id.blogs:
                    if (android.os.Build.VERSION.SDK_INT >= 21) {
                        Window window = getWindow();
                        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                        window.setStatusBarColor(getResources().getColor(R.color.colorAccent));
                    }
                    getSupportActionBar().show();
                    tv_title.setVisibility(View.VISIBLE);
                    tv_title.setText("Dulhaniyaa Inspiration");

//                    img_homeLogo.setVisibility(View.VISIBLE);
                    tool_text.setVisibility(View.VISIBLE);
//                    tv_title.setVisibility(View.GONE);

                    setToolbarBackground(true);

                    Fragment blogs = new Blogs();
                    setFragment(fragment);

                    getSupportFragmentManager().beginTransaction().replace(R.id.content, fragment).commit();
                    myToolbar.setNavigationIcon(R.drawable.filter_home);

                    myToolbar.setNavigationOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            Intent intent = new Intent(DulhaniyaaInspiration.this, RealWedding.class);
                            intent.putExtra("home_arrylist",blogResponseArrayList);
                            startActivity(intent);
                        }
                    });
                    return true;
            }
            return false;
        }
    };

    private void setToolbarBackground(boolean isHome) {
        if (myToolbar != null) {
            if (isHome) {
                myToolbar.setBackgroundColor(ContextCompat.getColor(DulhaniyaaInspiration.this, R.color.home_header_color));
            } else {
                myToolbar.setBackground(ContextCompat.getDrawable(DulhaniyaaInspiration.this, R.drawable.header_home));
            }
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        openApp = true;
        //SharedPreferenceWriter.getInstance(this).writeBooleanValue(SharedPreferenceKey.appOpenOrNOt, true);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        openApp = true;
        //SharedPreferenceWriter.getInstance(this).writeBooleanValue(SharedPreferenceKey.appOpenOrNOt, true);
    }

    @Override
    public void onPause() {
        super.onPause();
        openApp = false;
        //SharedPreferenceWriter.getInstance(this).writeBooleanValue(SharedPreferenceKey.appOpenOrNOt, false);
    }

    @Override
    public void onStop() {
        super.onStop();
        openApp = false;
        //SharedPreferenceWriter.getInstance(this).writeBooleanValue(SharedPreferenceKey.appOpenOrNOt, false);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        openApp = false;
        //SharedPreferenceWriter.getInstance(this).writeBooleanValue(SharedPreferenceKey.appOpenOrNOt, false);
    }

    void All(double lat, double log) {
        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        BottomNavigationViewHelper.disableShiftMode(navigation);
        myToolbar = findViewById(R.id.my_toolbar1);
        tool_text = myToolbar.findViewById(R.id.tool_text);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        tv_title = findViewById(R.id.tv_title);
        if (fcm_type != null) {
            navigation.setSelectedItemId(navigation.getMenu().getItem(3).getItemId());
            getSupportActionBar().show();
//            tv_title.setVisibility(View.VISIBLE);
//            tool_text.setVisibility(View.GONE);
//            tv_title.setText("My Orders");
//            img_homeLogo.setVisibility(View.GONE);
//
//            setToolbarBackground(false);
//
//            myToolbar.setNavigationIcon(null);
//
//            getSupportFragmentManager().beginTransaction().replace(R.id.content, new MyOrder()).commit();
        } else {
            Fragment fragment = new Photos();
            setFragment(fragment);
            getSupportFragmentManager().beginTransaction().replace(R.id.content, fragment).commit();
            myToolbar.setNavigationIcon(R.drawable.filter_home);

        tv_title.setVisibility(View.VISIBLE);
        tv_title.setText("Dulhaniyaa Inspiration");


//            img_homeLogo.setVisibility(View.VISIBLE);
            setToolbarBackground(true);


            Geocoder geocoder = new Geocoder(this, Locale.getDefault());
            List<Address> addresses = null;
            String cityName = "", stateName = "", countryName = "", countryCode = "", city = "";
            try {
                addresses = geocoder.getFromLocation(lat, log, 1);
                cityName = addresses.get(0).getAddressLine(0);
                //stateName = addresses.get(0).getAddressLine(1);
                // countryName = addresses.get(0).getAddressLine(2);
                city = addresses.get(0).getLocality();
                //countryCode = addresses.get(0).getCountryCode();

            } catch (IOException e) {
                e.printStackTrace();
                //                        addresses = geocoder.getFromLocation(lat, log, 1);
//                        countryName = addresses.get(0).getAddressLine(2);
//                        countryCode = addresses.get(0).getCountryCode();
                try {
                    cityName = addresses.get(0).getAddressLine(0);
                    city = addresses.get(0).getLocality();
                } catch (NullPointerException exp) {
                    exp.printStackTrace();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }


            } catch (Exception e) {
                e.printStackTrace();
            }
            if (city != null) {
                tool_text.setVisibility(View.VISIBLE);
                tool_text.setText(city);
            }
        }


        myToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(DulhaniyaaInspiration.this, RealWedding.class);
                intent.putExtra("home_arrylist",blogResponseArrayList);
                startActivity(intent);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == 1) {

            navigation.setSelectedItemId(navigation.getMenu().getItem(3).getItemId());
        }
    }

//    @Override
//    public void getBlogs(ArrayList<PhotosResponse> blogResponseArrayList) {
//        blogResponseArrayList=blogResponseArrayList;
//    }

}

