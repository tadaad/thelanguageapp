package com.tadinnovativeminds.aad.thelanguageapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;


public class ggrid extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid);
        TextView gg = findViewById(R.id.textView15);
        gg.setText("Family");
        CardView num = findViewById(R.id.nu);
        num.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent num = new Intent(ggrid.this, gnum.class);
                startActivity(num);

            }
        });
        CardView intro = findViewById(R.id.in);
        intro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intro = new Intent(ggrid.this, gintro.class);
                startActivity(intro);

            }
        });
        CardView week = findViewById(R.id.week);
        week.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent week = new Intent(ggrid.this, gweek.class);
                startActivity(week);

            }
        });

        CardView mon = findViewById(R.id.mon);
        mon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mon = new Intent(ggrid.this, gmonth.class);
                startActivity(mon);

            }
        });

        CardView col = findViewById(R.id.col);
        col.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent col = new Intent(ggrid.this, gcolours.class);
                startActivity(col);

            }
        });


        CardView sea = findViewById(R.id.sea);
        sea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sea = new Intent(ggrid.this, gseason.class);
                startActivity(sea);

            }
        });


    }
}
