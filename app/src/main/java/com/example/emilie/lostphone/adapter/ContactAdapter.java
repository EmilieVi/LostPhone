package com.example.emilie.lostphone.adapter;

import android.content.Context;
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


public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.Contact> {

    private Context context;

    private JSONArray res;

    private ListItemClickListener listener;

    public interface ListItemClickListener{
        void onListItemClick(int clickedItemIndex);
    }

    public ContactAdapter(Context c, JSONArray j, ListItemClickListener listener){
        this.context = c;
        this.res = j;
        this.listener = listener;
    }

    @Override
    public Contact onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.contact, parent,false);
        return new Contact(view);
    }

    @Override
    public void onBindViewHolder(Contact holder, int position) {
        String name = "null";
        try{
            name = res.getJSONObject(position).getString("contactName");
            String imageSrc = res.getJSONObject(position).getString("contactFace");
            if(!imageSrc.contentEquals("null")){
                AssetsLoader.setDrawableFromString(context,imageSrc,holder.contactFace);
            }
        }catch (JSONException e){}

        holder.contactName.setText(name);
        holder.itemView.setTag(position);

    }

    @Override
    public int getItemCount() {
        return res.length();
    }

    class Contact extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView contactFace;

        TextView contactName;

        public Contact(View itemView) {
            super(itemView);
            contactName = (TextView) itemView.findViewById(R.id.contactName);
            contactFace = (ImageView) itemView.findViewById(R.id.contactFace);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            listener.onListItemClick((int)itemView.getTag());
        }
    }
}
