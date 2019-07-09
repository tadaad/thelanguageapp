package com.tadinnovativeminds.aad.thelanguageapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;


public class quiz extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz);
        ImageView spa = findViewById(R.id.imageView7);
        ImageView bb = findViewById(R.id.imageView8);
        spa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ak = new Intent(quiz.this, choice.class);
                startActivity(ak);
            }
        });

        bb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent k = new Intent(quiz.this, choice2.class);
                startActivity(k);
            }
        });


    }
}
