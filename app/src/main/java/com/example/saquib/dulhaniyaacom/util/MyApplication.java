package com.example.saquib.dulhaniyaacom.util;

import android.content.Context;
import android.support.multidex.MultiDexApplication;

public class MyApplication extends MultiDexApplication {

    private static MyApplication myApplication = null;

    public static synchronized MyApplication getInstance()
    {
        if(myApplication == null)
        {
            return new MyApplication();
        }
        else
            return myApplication;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
//        MultiDex.install(this);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
//        BitmapAjaxCallback.clearCache();
    }
}
