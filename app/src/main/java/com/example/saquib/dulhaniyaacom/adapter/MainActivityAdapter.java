package com.example.saquib.dulhaniyaacom.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.saquib.dulhaniyaacom.fragment.Pager1;
import com.example.saquib.dulhaniyaacom.fragment.Pager2;
import com.example.saquib.dulhaniyaacom.fragment.Pager3;
import com.example.saquib.dulhaniyaacom.fragment.Pager4;

public class MainActivityAdapter extends FragmentPagerAdapter {


    public MainActivityAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new Pager1();
            case 1:
                return new Pager2();
            case 2:
                return new Pager3();
            case 3:
                return new Pager4();
//            case 4:
//                return new Profile();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 4;
    }
}
