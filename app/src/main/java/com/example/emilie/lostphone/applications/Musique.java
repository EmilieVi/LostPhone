package com.example.emilie.lostphone.applications;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.emilie.lostphone.R;
import com.example.emilie.lostphone.data.JSONloader;

import org.json.JSONObject;

public class Musique extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musique);
        setTitle("Musique maestro");
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.tri, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        TextView text = (TextView) findViewById(R.id.test);
        //JSONObject test = new JSONObject(JSONloader.loadJSON(this,"test.json"));
    }


}
