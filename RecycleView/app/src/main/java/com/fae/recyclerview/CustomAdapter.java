package com.fae.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Luscas on 15/06/2017.
 */

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private List<Item> items;
    private Context context;

    public CustomAdapter(List<Item> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @Override
    public CustomAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomAdapter.ViewHolder holder, int position) {
        Item item = items.get(position);

        holder.title.setText(item.getTitle());
        holder.subTitle.setText(item.getSubTitle());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView title;
        public TextView subTitle;
        public de.hdodenhof.circleimageview.CircleImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);

            title = (TextView)itemView.findViewById(R.id.title);
            subTitle = (TextView)itemView.findViewById(R.id.subTitle);
            imageView = (de.hdodenhof.circleimageview.CircleImageView)itemView.findViewById(R.id.imageViewLayout);

            imageView.setImageResource(R.drawable.cat);

        }
    }
}