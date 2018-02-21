package com.example.emilie.lostphone.applications;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.emilie.lostphone.AssetsLoader;
import com.example.emilie.lostphone.R;
import com.example.emilie.lostphone.adapter.VilleAdapter;

import org.json.JSONArray;
import org.json.JSONException;

public class Meteo extends AppCompatActivity {

    RecyclerView rv;
    VilleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meteo);
        setTitle("Météo");

        rv = (RecyclerView) findViewById(R.id.city_rv);
        rv.setLayoutManager(new LinearLayoutManager(this));

        JSONArray json = AssetsLoader.getJsonFromFile(this,R.raw.meteodata);
        adapter = new VilleAdapter(this,json);
        rv.setAdapter(adapter);

    }


}
