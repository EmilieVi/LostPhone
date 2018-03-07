package com.example.emilie.lostphone.applications.musique;

import android.content.Context;
import android.media.MediaPlayer;

/**
 * Created by Lenovo on 13/02/2018.
 */

public class CustomMediaPlayer implements MediaPlayer.OnCompletionListener{

    public boolean isPlaying;

    public boolean isActive;

    public MediaPlayer mediaPlayer;

    public CustomMediaPlayer(){
        isPlaying = false;
        isActive = false;
        mediaPlayer = new MediaPlayer();
        mediaPlayer.setOnCompletionListener(this);
    }


    public void pause(){
        mediaPlayer.pause();
        isPlaying = false;
    }


    public void start(){
        mediaPlayer.start();
        isPlaying = true;
        isActive = true;
    }

    @Override
    public void onCompletion(MediaPlayer mediaPlayer) {
        isActive = false;
        isPlaying = false;
    }

    public void release(){
        mediaPlayer.release();
    }

    public void create(Context c,int resId){
        mediaPlayer = MediaPlayer.create(c,resId);
        mediaPlayer.setOnCompletionListener(this);
    }
}
