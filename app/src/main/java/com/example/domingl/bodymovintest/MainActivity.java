package com.example.domingl.bodymovintest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Animatable2;
import android.graphics.drawable.Drawable;

public class MainActivity extends AppCompatActivity {
    private AnimatedVectorDrawable progress_record;
    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progress_record = (AnimatedVectorDrawable) getDrawable(R.drawable.animated);
        image = (ImageView) findViewById(R.id.imageView);

        image.setImageDrawable(progress_record);

        progress_record.start();

        progress_record.registerAnimationCallback (new Animatable2.AnimationCallback(){
            public void onAnimationEnd(Drawable drawable){
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        progress_record.start();
                    }
                }, 2000);
            }
        });
    }
}
