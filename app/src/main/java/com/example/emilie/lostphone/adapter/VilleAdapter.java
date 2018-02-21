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
 * Created by Lenovo on 13/02/2018.
 */

public class VilleAdapter extends RecyclerView.Adapter<VilleAdapter.Ville> {

    JSONArray res;

    Context context;

    public VilleAdapter(Context context,JSONArray res){
        this.res = res;
        this.context = context;
    }

    @Override
    public VilleAdapter.Ville onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.city_view,parent,false);
        return new Ville(view);
    }

    @Override
    public void onBindViewHolder(VilleAdapter.Ville holder, int position) {
        String city_name = "";
        String city_temperature = "";
        try{
            JSONObject temp = res.getJSONObject(position);
            city_name = temp.getString("city_name");
            city_temperature = temp.getString("city_temperature");
            String icon = temp.getString("city_weather");
            if(!icon.contentEquals("null")){
                AssetsLoader.setDrawableFromString(context,icon,holder.meteo_image);
            }
        }catch(JSONException e){}
        holder.city_name.setText(city_name);
        holder.city_temperature.setText(city_temperature);
    }

    @Override
    public int getItemCount() {
        return res.length();
    }

    class Ville extends RecyclerView.ViewHolder{

        TextView city_name;
        TextView city_temperature;
        ImageView meteo_image;

        public Ville(View itemView) {
            super(itemView);
            city_name = (TextView)itemView.findViewById(R.id.city_name);
            city_temperature = (TextView)itemView.findViewById(R.id.temperature);
            meteo_image = (ImageView) itemView.findViewById(R.id.meteo_image);
        }
    }
}
