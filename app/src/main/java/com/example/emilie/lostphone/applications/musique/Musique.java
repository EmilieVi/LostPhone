package com.example.emilie.lostphone.applications.musique;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;

import com.example.emilie.lostphone.AssetsLoader;
import com.example.emilie.lostphone.R;
import com.example.emilie.lostphone.adapter.MusiqueAdapter;

import org.json.JSONArray;

public class Musique extends AppCompatActivity implements MusiqueAdapter.ListItemClickListener,View.OnClickListener{

    RecyclerView rv;

    MusiqueAdapter musiqueAdapter;

    static CustomMediaPlayer mediaPlayer = new CustomMediaPlayer();
    ImageButton play;
    ImageButton next;
    ImageButton previous;

    static int currentMusic = -1;

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

        rv = (RecyclerView) findViewById(R.id.music_rv);
        rv.setLayoutManager(new LinearLayoutManager(this));
        JSONArray json = AssetsLoader.getJsonFromFile(this,R.raw.musiquedata);
        musiqueAdapter = new MusiqueAdapter(this,json,this);
        rv.setAdapter(musiqueAdapter);

        play = (ImageButton) findViewById(R.id.play);
        play.setOnClickListener(this);

        next = (ImageButton)findViewById(R.id.next);
        next.setOnClickListener(this);

        previous = (ImageButton)findViewById(R.id.previous);
        previous.setOnClickListener(this);

        if(mediaPlayer.isPlaying){
            play.setImageResource(R.drawable.ic_pause_black_24dp);
        }
        //currentMusic = -1;

    }


    @Override
    public void onListItemClick(String musicFileSrc,int position) {
        final int fileId = AssetsLoader.getMusicFromString(this,musicFileSrc);
        currentMusic = position;
        if(fileId!=0){
            play.setImageResource(R.drawable.ic_pause_black_24dp);
            mediaPlayer.release();
            mediaPlayer.create(this,fileId);
            mediaPlayer.start();
        }
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.play: onPlayPress();
                break;
            case R.id.next: onNextPress();
                break;
            case R.id.previous: onPreviousPress();
                break;
        }
    }

    public void onPlayPress(){
        if(mediaPlayer.isActive){
            if(mediaPlayer.isPlaying){
                play.setImageResource(R.drawable.ic_play_arrow_black_24dp);
                mediaPlayer.pause();
            }else{
                play.setImageResource(R.drawable.ic_pause_black_24dp);
                mediaPlayer.start();
            }
        }
    }

    public void onNextPress(){
        if(currentMusic!=-1){
            if(currentMusic+1<musiqueAdapter.getItemCount()){
                currentMusic++;
            }else{
                currentMusic = 0;
            }
            String source = musiqueAdapter.getMusicByPos(currentMusic);
            if(!source.contentEquals("")){
                mediaPlayer.release();
                mediaPlayer.create(this,AssetsLoader.getMusicFromString(this,source));
                mediaPlayer.start();
            }
        }
    }

    public void onPreviousPress(){
        if(currentMusic!=-1){
            if(currentMusic-1>=0){
                currentMusic--;
            }else{
                currentMusic = musiqueAdapter.getItemCount();
            }
            String source = musiqueAdapter.getMusicByPos(currentMusic);
            if(!source.contentEquals("")){
                mediaPlayer.release();
                mediaPlayer.create(this,AssetsLoader.getMusicFromString(this,source));
                mediaPlayer.start();
            }
        }
    }
}
