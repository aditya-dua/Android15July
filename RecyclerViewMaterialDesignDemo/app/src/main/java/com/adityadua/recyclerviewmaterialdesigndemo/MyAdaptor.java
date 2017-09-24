package com.adityadua.recyclerviewmaterialdesigndemo;

import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by AdityaDua on 17/09/17.
 */

public class MyAdaptor  extends RecyclerView.Adapter<MyAdaptor.ViewHolder>{
    public MyAdaptor(ItemData[] itemsData) {
        this.itemsData = itemsData;
    }

    private ItemData[] itemsData;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.row,null);
        ViewHolder vh = new ViewHolder(view);



        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.txtViewTitle.setText(itemsData[position].getName());
        holder.imgViewIcon.setImageResource(itemsData[position].getUrl());

        holder.txtViewTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v,"Clicked On::"+itemsData[position].getName(),Snackbar.LENGTH_LONG)
                        .setAction("Action Here",null).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return itemsData.length;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView txtViewTitle;
        public ImageView imgViewIcon;


        public ViewHolder(View itemView) {
            super(itemView);

            txtViewTitle = (TextView) itemView.findViewById(R.id.textView);
            imgViewIcon = (ImageView) itemView.findViewById(R.id.imageView);

        }
    }
}
