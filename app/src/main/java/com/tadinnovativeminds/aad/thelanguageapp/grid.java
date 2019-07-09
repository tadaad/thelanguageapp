package com.tadinnovativeminds.aad.thelanguageapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;


public class grid extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid);

        CardView num = findViewById(R.id.nu);
        num.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent num = new Intent(grid.this, numbers.class);
                startActivity(num);

            }
        });
        CardView intro = findViewById(R.id.in);
        intro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intro = new Intent(grid.this, introduction.class);
                startActivity(intro);

            }
        });
        CardView week = findViewById(R.id.week);
        week.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent week = new Intent(grid.this, weeks.class);
                startActivity(week);

            }
        });

        CardView mon = findViewById(R.id.mon);
        mon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mon = new Intent(grid.this, months.class);
                startActivity(mon);

            }
        });

        CardView col = findViewById(R.id.col);
        col.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent col = new Intent(grid.this, colours.class);
                startActivity(col);

            }
        });


        CardView sea = findViewById(R.id.sea);
        sea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sea = new Intent(grid.this, seasons.class);
                startActivity(sea);

            }
        });


    }
}
