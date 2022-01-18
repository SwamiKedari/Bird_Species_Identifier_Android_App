package com.srk.birdspeciesidentifier;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.*;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.Image;
import android.view.*;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

public class adapterForButtons extends RecyclerView.Adapter<adapterForButtons.ViewHolder> {
    //private List<String> data=new ArrayList<>();
    //private List<Integer> images=new ArrayList<>();
    private String[] data=new String[4];
    private int[] images=new int[4];
    private static Listener listener;
    public  static interface Listener{
        public void onClick(int p);
    }
    public adapterForButtons(int[] images,String[] data){
        this.data=data;
        this.images=images;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private CardView cardView;
        public ViewHolder(CardView v){
            super(v);
            cardView=v;
        }

    }



    public static  void setListener(Listener l){
        listener=l;
    }
    public adapterForButtons.ViewHolder onCreateViewHolder(ViewGroup parent,int viewType){

        CardView cv=(CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.cardviewforbuttons,parent,false);
        return new ViewHolder(cv);

    }
    public void onBindViewHolder(ViewHolder holder , @SuppressLint("RecyclerView") int position){
        CardView c=holder.cardView;
        TextView t=(TextView) c.findViewById(R.id.textForButtons);
        t.setText(data[position]);
        ImageView i=(ImageView)c.findViewById(R.id.imageForButtons);
        i.setImageResource(images[position]);
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener!=null){
                    listener.onClick(position);
                }
            }
        });



    }
    public int getItemCount(){

        return data.length;
    }
}


