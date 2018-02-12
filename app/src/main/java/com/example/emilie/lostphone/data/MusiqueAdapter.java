package com.example.emilie.lostphone.data;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.emilie.lostphone.R;

/**
 * Created by Emilie on 30-01-18.
 */

public class MusiqueAdapter extends RecyclerView.Adapter<MusiqueAdapter.MusiqueViewHolder>{

    private Cursor cursor;
    private Context context;
    private ListItemClickListener listener;

    public interface ListItemClickListener{
        void onListItemClick(int clickItemIndex);
    }

    @Override
    public MusiqueAdapter.MusiqueViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(MusiqueAdapter.MusiqueViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class MusiqueViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView image;
        TextView titre;
        TextView album;

        public MusiqueViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.image);
            titre = (TextView) itemView.findViewById(R.id.titre);
            album = (TextView) itemView.findViewById(R.id.album);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            listener.onListItemClick((int)itemView.getTag());
        }
    }
}
