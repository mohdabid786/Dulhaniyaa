package com.example.saquib.dulhaniyaacom.activities;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.saquib.dulhaniyaacom.R;
import com.example.saquib.dulhaniyaacom.adapter.MainActivityAdapter;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private MainActivityAdapter mAdaptor;
    private LinearLayout dotsLayout;
    private TextView[] dots;
    private int[] layouts;
    private PrefManager prefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager=(ViewPager)findViewById(R.id.pager);
        mAdaptor= new MainActivityAdapter(getSupportFragmentManager());
        viewPager.setAdapter(mAdaptor);



//        getSupportActionBar().hide();

//        Window w =getWindow();
//        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
//
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);
//        getSupportActionBar().hide();

    }
}



// Checking for first time launch - before calling setContentView()
//        prefManager = new PrefManager(this);
//                if (!prefManager.isFirstTimeLaunch()) {
//                launchHomeScreen();
//                finish();
//                }
//
//                // Making notification bar transparent
//                if (Build.VERSION.SDK_INT >= 21) {
//                getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
//                }
//
//                setContentView(R.layout.activity_main);
//
//                viewPager = (ViewPager) findViewById(R.id.pager);
//                dotsLayout = (LinearLayout) findViewById(R.id.layoutDots);
//
//
//                // layouts of all welcome sliders
//                // add few more layouts if you want
//                layouts = new int[]{
//                R.layout.fragment_pager1,
//                R.layout.fragment_pager2,
//                R.layout.fragment_pager3,
//                R.layout.fragment_pager4};
//
//                // adding bottom dots
//                addBottomDots(0);
//
//                // making notification bar transparent
//                changeStatusBarColor();
//
//                myViewPagerAdapter = new MyViewPagerAdapter();
//                viewPager.setAdapter(myViewPagerAdapter);
//                viewPager.addOnPageChangeListener(viewPagerPageChangeListener);
//
//                }
//
//private void addBottomDots(int currentPage) {
//        dots = new TextView[layouts.length];
//
//        int[] colorsActive = getResources().getIntArray(R.array.array_dot_active);
//        int[] colorsInactive = getResources().getIntArray(R.array.array_dot_inactive);
//
//        dotsLayout.removeAllViews();
//        for (int i = 0; i < dots.length; i++) {
//        dots[i] = new TextView(this);
//        dots[i].setText(Html.fromHtml("&#8226;"));
//        dots[i].setTextSize(35);
//        dots[i].setTextColor(colorsInactive[currentPage]);
//        dotsLayout.addView(dots[i]);
//        }
//
//        if (dots.length > 0)
//        dots[currentPage].setTextColor(colorsActive[currentPage]);
//        }
//
//private int getItem(int i) {
//        return viewPager.getCurrentItem() + i;
//        }
//
//private void launchHomeScreen() {
//        prefManager.setFirstTimeLaunch(false);
//        startActivity(new Intent(MainActivity.this, Welcome.class));
//        finish();
//        }
//
//        //	viewpager change listener
//        ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener() {
//
//@Override
//public void onPageSelected(int position) {
//        addBottomDots(position);
//        }
//
//@Override
//public void onPageScrolled(int arg0, float arg1, int arg2) {
//
//        }
//
//@Override
//public void onPageScrollStateChanged(int arg0) {
//
//        }
//        };
//
///**
// * Making notification bar transparent
// */
//private void changeStatusBarColor() {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//        Window window = getWindow();
//        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//        window.setStatusBarColor(Color.TRANSPARENT);
//        }
//        }
//
///**
// * View pager adapter
// */
//public class MyViewPagerAdapter extends PagerAdapter {
//    private LayoutInflater layoutInflater;
//
//    public MyViewPagerAdapter() {
//    }
//
//    @Override
//    public Object instantiateItem(ViewGroup container, int position) {
//        layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//
//        View view = layoutInflater.inflate(layouts[position], container, false);
//        container.addView(view);
//
//        return view;
//    }
//
//    @Override
//    public int getCount() {
//        return layouts.length;
//    }
//
//    @Override
//    public boolean isViewFromObject(View view, Object obj) {
//        return view == obj;
//    }
//
//
//    @Override
//    public void destroyItem(ViewGroup container, int position, Object object) {
//        View view = (View) object;
//        container.removeView(view);
//    }