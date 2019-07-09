package com.tadinnovativeminds.aad.thelanguageapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class hard3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hard13);
        TextView asa = findViewById(R.id.textView16);
        asa.setText("I am  a Woman");
        TextView one = findViewById(R.id.textView20);
        one.setText("4/10");
        TextView sa = findViewById(R.id.textView6);
        TextView saa = findViewById(R.id.textView7);
        TextView saaa = findViewById(R.id.textVie);
        TextView saaaa = findViewById(R.id.textVi);

        sa.setText("yo sujer mujer");
        saa.setText("yo sujer chica");
        saaa.setText("tu sujer man");
        saaaa.setText("ella la chico");
        Button next = findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next = new Intent(hard3.this, hard4.class);
                startActivity(next);

            }
        });

        ImageView back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bck = new Intent(hard3.this, choice.class);
                startActivity(bck);
            }
        });
        final CardView vac = findViewById(R.id.tad);
        final CardView wrong = findViewById(R.id.wrong);
        final CardView wrongg = findViewById(R.id.wrongg);
        final CardView correct = findViewById(R.id.correct);
        vac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(hard3.this, "Correct! press next to continue", Toast.LENGTH_SHORT).show();
                vac.setCardBackgroundColor(Color.GREEN);

            }
        });

        wrong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(hard3.this, "WRONG!!!", Toast.LENGTH_SHORT).show();
                wrong.setCardBackgroundColor(Color.RED);

            }
        });


        wrongg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(hard3.this, "WRONG!!!", Toast.LENGTH_SHORT).show();
                wrongg.setCardBackgroundColor(Color.RED);

            }
        });
        correct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(hard3.this, "WRONG!!!", Toast.LENGTH_SHORT).show();
                correct.setCardBackgroundColor(Color.RED);

            }
        });
    }
}