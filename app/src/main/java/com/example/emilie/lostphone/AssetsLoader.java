package com.example.emilie.lostphone;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Lenovo on 6/02/2018.
 */

public class AssetsLoader {
    public static JSONArray getJsonFromFile(Context ctx, int resId)
    {
        JSONArray json = null;
        InputStream inputStream = ctx.getResources().openRawResource(resId);

        InputStreamReader inputreader = new InputStreamReader(inputStream);
        BufferedReader buffreader = new BufferedReader(inputreader);
        String line;
        StringBuilder text = new StringBuilder();

        try {
            while (( line = buffreader.readLine()) != null) {
                text.append(line);
                text.append('\n');
            }
            json = new JSONArray(text.toString());

        } catch (IOException e) {
            return null;
        } catch (JSONException e){
            return null;
        }
        return json;
    }

    public static void  setDrawableFromString(Context c, String imgName, ImageView image){
        final int resId = c.getResources().getIdentifier(imgName, "drawable",c.getPackageName());
        image.setImageResource(resId);
    }

    public static int getMusicFromString(Context c,String fileName){
        final int resId = c.getResources().getIdentifier(fileName,"raw",c.getPackageName());
        return resId;
    }
}
