package com.example.saquib.dulhaniyaacom.util;

import android.graphics.Typeface;
import android.util.Log;

import java.util.HashMap;

public class CustomFontFamily {

    static CustomFontFamily customFontFamily;
    HashMap<String,String> fontMap=new HashMap<>();
    HashMap<String,Typeface> fontCache=new HashMap<>();

    public static CustomFontFamily getInstance()
    {
        if(customFontFamily==null)
            customFontFamily=new CustomFontFamily();
        return customFontFamily;
    }
    public void addFont(String alias, String fontName){
        fontMap.put(alias,fontName);
    }
    public Typeface getFont(String alias)
    {
        String fontFilename = fontMap.get(alias);
        if (fontFilename == null) {
            Log.e("", "Font not available with name " + alias);
            return null;
        }
        if(fontCache.containsKey(alias))
            return fontCache.get(alias);
        else
        {
            Typeface typeface = Typeface.createFromAsset(DulhaniyaaApplication.getContext().getAssets(), "fonts/" + fontFilename);
            fontCache.put(fontFilename, typeface);
            return typeface;
        }
    }
}
