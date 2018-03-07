package com.example.emilie.lostphone.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.emilie.lostphone.AssetsLoader;
import com.example.emilie.lostphone.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Emilie on 07-03-18.
 */

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageHolder> {

    Context context;

    JSONArray res;

    public ImageAdapter(Context c, JSONArray j){
        this.context = c;
        this.res = j;
    }

    @Override
    public ImageHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.image_view, parent,false);
        return new ImageAdapter.ImageHolder(view);
    }

    @Override
    public void onBindViewHolder(ImageHolder holder, int position) {
        String date = "11/11/11";
        try{
            JSONObject obj = res.getJSONObject(position);
            date = obj.getString("date");
            AssetsLoader.setDrawableFromString(context,obj.getString("img"),holder.img);
        } catch(JSONException e){}

        holder.date.setText(date);
    }

    @Override
    public int getItemCount() {
        return res.length();
    }

    class ImageHolder extends RecyclerView.ViewHolder{

        ImageView img;

        TextView date;

        public ImageHolder(View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.img_img);
            date = (TextView) itemView.findViewById(R.id.img_date);
        }
    }
}
