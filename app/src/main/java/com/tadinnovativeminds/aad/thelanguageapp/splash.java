package com.tadinnovativeminds.aad.thelanguageapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.VideoView;

public class splash extends AppCompatActivity {
    Handler handler;
    ImageView tad;
    ImageView mad;
    Animation fromdown;
    Animation fromup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        VideoView vt = findViewById(R.id.videoView);
        //tad=(ImageView)findViewById(R.id.imageView);
        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.sth);
        vt.setVideoURI(uri);
        vt.start();
//fromdown= AnimationUtils.loadAnimation(this,R.anim.ta);
//fromup=AnimationUtils.loadAnimation(this,R.anim.td);

//        tad.setAnimation(fromdown);

        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(splash.this, intro_activity.class);
                startActivity(intent);
                finish();
            }
        }, 2000);
    }


}
