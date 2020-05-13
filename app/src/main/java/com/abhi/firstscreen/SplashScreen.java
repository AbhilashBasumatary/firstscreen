package com.abhi.firstscreen;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {

    private static int SPLASH_SCREEN = 5000;

    Animation topAnim, bottomAnim;
    ImageView image1, image2, image3, image4, image5, image6, image7, image8, image9, image10;
    TextView logo, tag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);

        topAnim = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);

        image1 = findViewById(R.id.top);
        image2 = findViewById(R.id.left);
        image3 = findViewById(R.id.right);
        image4 = findViewById(R.id.bottom);
        image5 = findViewById(R.id.bottomleft);
        image6 = findViewById(R.id.bottomright);
        image7 = findViewById(R.id.topleft);
        image8 = findViewById(R.id.topright);
        image9 = findViewById(R.id.worldm);
        image10 = findViewById(R.id.markperson);

        logo = findViewById(R.id.textView);
        tag = findViewById(R.id.textView2);

        image1.setAnimation(topAnim);
        image2.setAnimation(topAnim);
        image3.setAnimation(topAnim);
        image4.setAnimation(topAnim);
        image5.setAnimation(topAnim);
        image6.setAnimation(topAnim);
        image7.setAnimation(topAnim);
        image8.setAnimation(topAnim);
        image9.setAnimation(topAnim);
        image10.setAnimation(topAnim);

        logo.setAnimation(bottomAnim);
        tag.setAnimation(bottomAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this,IntroActivity.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN);

    }
}
