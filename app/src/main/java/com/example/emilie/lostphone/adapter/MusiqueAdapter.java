package com.example.emilie.lostphone.adapter;

import android.content.Context;
import android.database.Cursor;
import android.os.Debug;
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
 * Created by Emilie on 30-01-18.
 */

public class MusiqueAdapter extends RecyclerView.Adapter<MusiqueAdapter.MusiqueViewHolder>{

    private JSONArray res;
    private Context context;
    private ListItemClickListener listener;

    public interface ListItemClickListener{
        void onListItemClick(String musicFileSrc, int position);
    }

    public MusiqueAdapter(Context c, JSONArray j, MusiqueAdapter.ListItemClickListener listener){
        this.context = c;
        this.res = j;
        this.listener = listener;
    }

    @Override
    public MusiqueAdapter.MusiqueViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.musique_view, parent,false);
        return new MusiqueViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MusiqueAdapter.MusiqueViewHolder holder, int position) {
        String name = "null";
        String album = "null";
        String imageSrc = "null";
        try{
            JSONObject temp = res.getJSONObject(position);
            name = temp.getString("musicName");
            album = temp.getString("albumName");
            String image = temp.getString("albumImage");
            imageSrc = temp.getString("musicSource");
            if(!image.contentEquals("null")){
                AssetsLoader.setDrawableFromString(context,image,holder.image);
            }
        }catch (JSONException e){}
        holder.titre.setText(name);
        holder.album.setText(album);
        holder.itemView.setTag(imageSrc);

    }

    public String getMusicByPos(int position){
        try{
            return res.getJSONObject(position).getString("musicSource");
        }catch(JSONException e){
            return "";
        }
    }

    @Override
    public int getItemCount() {
        return res.length();
    }

    class MusiqueViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView image;
        TextView titre;
        TextView album;

        public MusiqueViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.photo);
            titre = (TextView) itemView.findViewById(R.id.titre);
            album = (TextView) itemView.findViewById(R.id.album);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            listener.onListItemClick((String)itemView.getTag(),getAdapterPosition());
        }
    }
}
