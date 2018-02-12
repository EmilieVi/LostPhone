package com.example.emilie.lostphone.data;

import java.io.IOException;
import java.io.InputStream;
import android.content.Context;

/**
 * Created by Emilie on 30-01-18.
 */

public class JSONloader {
    public static String loadJSON(Context context, String source){
        String json = null;
        try{
            InputStream is = context.getAssets().open(source);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer,"UTF-8");
        }catch(IOException ex) {
            ex.printStackTrace();
            return null;
        }

        return json;
    }
}
