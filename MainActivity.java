package com.srk.birdspeciesidentifier;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.*;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.app.*;

import java.util.ArrayList;
import android.content.*;

public class MainActivity extends AppCompatActivity {

    private String[] titles;
    private ListView drawerList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int[] images={
                R.drawable.birdlist,R.drawable.identifierimage,R.drawable.birdimages,R.drawable.sounds1

        };
        String[] texts={
                "List of Birds","Bird Identification","Bird Images","Bird Sounds"
        };
        adapterForButtons a=new adapterForButtons(images,texts);
        RecyclerView recyclerView=findViewById(R.id.buttons);
        recyclerView.setAdapter(a);
        GridLayoutManager LayoutManager=new GridLayoutManager(this,2,RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(LayoutManager);
        adapterForButtons.setListener(new adapterForButtons.Listener() {
            @Override
            public void onClick(int p) {
                if(p==0){
                    Intent i=new Intent(MainActivity.this,ListOfBirds.class);
                    startActivity(i);
                }
                else if(p==1){
                    Intent i=new Intent(MainActivity.this,BirdIdentification.class);
                    startActivity(i);
                }
                else if(p==2){
                    Intent i=new Intent(MainActivity.this,ImageActivity.class);
                    startActivity(i);
                }
                else if(p==3){
                    Intent i=new Intent(MainActivity.this,soundActivity.class);
                    startActivity(i);
                }
            }
        });





    }
    /*private class drawListener implements ListView.OnItemClickListener{
        @Override
        public void onItemClick(AdapterView<?> parent, View view,int position,long id){
            selectItem(position);
        }
    }
    private void selectItem(int i){
        Fragment fragment;
        switch(i){
            case 1:
                fragment=new listOfBirds();
                break;
            case 2:
                fragment=new birdIdentification();
                break;
            default:
                fragment=new home();


        }

        FragmentTransaction ft=getFragmentManager().beginTransaction();
        ft.replace(R.id.contentFrame,fragment);
        ft.addToBackStack(null);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.commit();
    }*/
}