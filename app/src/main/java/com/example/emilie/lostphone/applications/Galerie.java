package com.example.emilie.lostphone.applications;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.emilie.lostphone.AssetsLoader;
import com.example.emilie.lostphone.R;
import com.example.emilie.lostphone.adapter.ImageAdapter;

public class Galerie extends AppCompatActivity {

    ImageAdapter adapter;

    RecyclerView galerie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_galerie);

        galerie = (RecyclerView) findViewById(R.id.image_rv);

        adapter = new ImageAdapter(this,AssetsLoader.getJsonFromFile(this,R.raw.pictures));
        galerie.setLayoutManager(new LinearLayoutManager(this));
        galerie.setAdapter(adapter);
    }
}
