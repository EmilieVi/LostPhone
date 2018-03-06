package com.example.emilie.lostphone;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.emilie.lostphone.applications.BlocNotes;
import com.example.emilie.lostphone.applications.Calculatrice;
import com.example.emilie.lostphone.applications.Galerie;
import com.example.emilie.lostphone.applications.messages.Messsages;
import com.example.emilie.lostphone.applications.Meteo;
import com.example.emilie.lostphone.applications.musique.Musique;
import com.example.emilie.lostphone.applications.Plan;

public class Hub extends AppCompatActivity implements View.OnClickListener{

    ImageView meteo;
    ImageView plan;
    ImageView musique;
    ImageView galerie;
    ImageView messages;
    ImageView blocnote;
    ImageView calculatrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hub);

        meteo = (ImageView) findViewById(R.id.meteo);
        plan = (ImageView) findViewById(R.id.plan);
        musique = (ImageView) findViewById(R.id.musique);
        galerie = (ImageView) findViewById(R.id.galerie);
        messages = (ImageView) findViewById(R.id.messages);
        blocnote = (ImageView) findViewById(R.id.blocnotes);
        calculatrice = (ImageView) findViewById(R.id.calculatrice);

        meteo.setOnClickListener(this);
        plan.setOnClickListener(this);
        musique.setOnClickListener(this);
        galerie.setOnClickListener(this);
        messages.setOnClickListener(this);
        blocnote.setOnClickListener(this);
        calculatrice.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.meteo:
                intent = new Intent(this, Meteo.class);
                startActivity(intent);
                break;

            case R.id.plan:
                intent = new Intent(this, Plan.class);
                startActivity(intent);
                break;

            case R.id.musique:
                intent = new Intent(this, Musique.class);
                startActivity(intent);
                break;

            case R.id.galerie:
                intent = new Intent(this, Galerie.class);
                startActivity(intent);
                break;

            case R.id.messages:
                intent = new Intent(this, Messsages.class);
                startActivity(intent);
                break;

            case R.id.blocnotes:
                intent = new Intent(this, BlocNotes.class);
                startActivity(intent);
                break;

            case R.id.calculatrice:
                intent = new Intent(this, Calculatrice.class);
                startActivity(intent);
                break;
        }
    }
}
