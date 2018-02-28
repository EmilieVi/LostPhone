package com.example.emilie.lostphone.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.emilie.lostphone.R;

import org.json.JSONArray;
import org.json.JSONException;

/**
 * Created by Lenovo on 6/02/2018.
 */

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.Message> {

    JSONArray res;

    Context context;

    public MessageAdapter(Context context, JSONArray json){
        super();
        this.context = context;
        this.res = json;
    }

    @Override
    public Message onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view;
        switch (viewType){
            case 0: view = inflater.inflate(R.layout.me_message,parent,false);
                break;
            case 1: view = inflater.inflate(R.layout.him_message,parent,false);
                break;
            default: view = null;
                break;
        }
        return new Message(view);
    }

    @Override
    public int getItemViewType(int position){
        String author;
        try{
            author = res.getJSONObject(position).getString("author");
        }catch(JSONException e){ author = "";}

        if(author.contentEquals("me")){
            return 0;
        }else{
            return 1;
        }
    }

    @Override
    public void onBindViewHolder(Message holder, int position) {
        String message = "error";
        try{
            message = res.getJSONObject(position).getString("message");
        }catch (JSONException e){}
        holder.message.setText(message);
    }

    @Override
    public int getItemCount() {
        return res.length();
    }

    class Message extends RecyclerView.ViewHolder{
        TextView message;
        public Message(View itemView) {
            super(itemView);
            message = (TextView) itemView.findViewById(R.id.message);
        }
    }
}
