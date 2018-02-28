package com.example.emilie.lostphone.applications.messages;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.emilie.lostphone.AssetsLoader;
import com.example.emilie.lostphone.R;
import com.example.emilie.lostphone.adapter.ContactAdapter;

import org.json.JSONArray;

public class Messsages extends AppCompatActivity implements ContactAdapter.ListItemClickListener{

    public static final String CONTACT_ID = "com.example.emilie.lostphone.applications.messages.contact_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messsages);

        setTitle("Contacts");

        RecyclerView rv = (RecyclerView) findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(this));

        JSONArray json = AssetsLoader.getJsonFromFile(this,R.raw.data);

        ContactAdapter adapter = new ContactAdapter(this,json,this);
        rv.setAdapter(adapter);

    }

    @Override
    public void onListItemClick(int clickedItemIndex) {
        Intent intent = new Intent(this, Conversation.class);
        intent.putExtra(CONTACT_ID,clickedItemIndex);
        startActivity(intent);
    }
}
