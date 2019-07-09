package com.tadinnovativeminds.aad.thelanguageapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;


public class choice extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
        CardView bb = findViewById(R.id.card);
        CardView b = findViewById(R.id.aa);
        bb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent hu = new Intent(choice.this, grid.class);
                startActivity(hu);
            }
        });

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent u = new Intent(choice.this, hard.class);
                startActivity(u);
            }
        });


    }
}
