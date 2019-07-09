package com.tadinnovativeminds.aad.thelanguageapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class lang extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.laguageselection);

        //   VideoView vt=(VideoView) findViewById(R.id.aa);
        //tad=(ImageView)findViewById(R.id.imageView);
        // Uri uri= Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.kk);
        //vt.setVideoURI(uri);
        //vt.start();


        RecyclerView recyclerView = findViewById(R.id.ww);
        List<item> mlist = new ArrayList<>();
        mlist.add(new item(R.drawable.spanish, "LEARN SPANISH", R.drawable.ic_launcher_foreground, 2500));
        mlist.add(new item(R.drawable.german, "ECO CAR", R.drawable.german, 5500));
        mlist.add(new item(R.drawable.pp, "Eleco Shoes", R.drawable.pp, 8500));


        adapter adapter = new adapter(this, mlist);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }


}