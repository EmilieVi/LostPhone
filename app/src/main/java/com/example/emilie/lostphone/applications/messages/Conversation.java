package com.example.emilie.lostphone.applications.messages;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.emilie.lostphone.AssetsLoader;
import com.example.emilie.lostphone.R;
import com.example.emilie.lostphone.adapter.MessageAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import static com.example.emilie.lostphone.applications.messages.Messsages.CONTACT_ID;

public class Conversation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversation);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.conversation_action_bar);

        Intent intent = getIntent();
        int id = intent.getIntExtra(CONTACT_ID,-1);



        JSONArray json = AssetsLoader.getJsonFromFile(this,R.raw.data);

        try{
            String contactName = json.getJSONObject(id).getString("contactName");
            View view = getSupportActionBar().getCustomView();
            TextView tv = (TextView)view.findViewById(R.id.contact_name);
            tv.setText(contactName);
            ImageView iv= (ImageView)view.findViewById(R.id.contact_face);
            String contactFace = json.getJSONObject(id).getString("contactFace");
            if(!contactFace.contentEquals("null"))AssetsLoader.setDrawableFromString(this,contactFace,iv);
        }catch(JSONException e){}




        JSONArray conversation = getConversationById(json,id);
        if(conversation!=null) {
            RecyclerView rv = (RecyclerView) findViewById(R.id.messageDisplay);
            rv.setLayoutManager(new LinearLayoutManager(this));


            MessageAdapter adapter = new MessageAdapter(this, conversation);
            rv.setAdapter(adapter);
        }
    }

    private JSONArray getConversationById(JSONArray json, int id){
        try{
            JSONObject contact = json.getJSONObject(id);
            return contact.getJSONArray("conversation");
        }catch(JSONException e){
            return null;
        }
    }
}
