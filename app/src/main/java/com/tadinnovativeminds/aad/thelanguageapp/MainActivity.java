package com.tadinnovativeminds.aad.thelanguageapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final VideoView vt = findViewById(R.id.videoView2);
        //tad=(ImageView)findViewById(R.id.imageView);
        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.extra);
        vt.setVideoURI(uri);
        vt.start();


        Button b = findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent k = new Intent(MainActivity.this, lang.class);
                startActivity(k);
            }
        });

    }
}
