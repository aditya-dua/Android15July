package com.adityadua.webservicesdemo.adaptor;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.adityadua.webservicesdemo.R;
import com.adityadua.webservicesdemo.model.DataHandler;

import java.util.List;

/**
 * Created by AdityaDua on 29/10/17.
 */

public class DataAdaptor extends RecyclerView.Adapter<DataAdaptor.ViewHolder> {

    ClickListener clickListener;
    Context context;
    List<DataHandler> data;

    public DataAdaptor(Context context, List<DataHandler> data) {
        this.context = context;
        this.data = data;
    }

    public void setClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(context).inflate(R.layout.row,null);
       ViewHolder viewHolder = new ViewHolder(view);



        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        holder.name.setText(data.get(position).getName());
        holder.order.setText(data.get(position).getOrder());
        holder.character.setText(data.get(position).getCharacter());

        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(clickListener !=null){
                    clickListener.itemClicked(v,position);
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    // own view holder :::

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView name,order,character;
        RecyclerView parent;

        public ViewHolder(View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.name);
            order = (TextView) itemView.findViewById(R.id.order);
            character = (TextView) itemView.findViewById(R.id.character);

            parent = (RecyclerView) itemView.findViewById(R.id.recycler);

        }
    }

    public interface ClickListener{
        void itemClicked(View v,int position);

    }
}
