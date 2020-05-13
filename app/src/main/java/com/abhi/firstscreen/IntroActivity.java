package com.abhi.firstscreen;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.github.paolorotolo.appintro.AppIntro;
import com.github.paolorotolo.appintro.AppIntroFragment;

public class IntroActivity extends AppIntro {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addSlide(AppIntroFragment.newInstance("Welcome to Zone App", "An App that ensures that you are not Disturbed while Working",
                R.drawable.videocall, ContextCompat.getColor(getApplicationContext(), R.color.secondColor)));

        addSlide(AppIntroFragment.newInstance("Your Best Working Companion", "Mark the Locations where you don't want to be Disturbed",
                R.drawable.bluesign, ContextCompat.getColor(getApplicationContext(), R.color.firstColor)));

        addSlide(AppIntroFragment.newInstance("Never Miss Anything", "A Separate Notification Panel to Remind you what you Missed during Working Hours",
                R.drawable.bell, ContextCompat.getColor(getApplicationContext(), R.color.thirdColor)));
        setFadeAnimation();

        sharedPreferences = getApplicationContext().getSharedPreferences("MinePreferences", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        if(sharedPreferences!=null){

            boolean checkShared = sharedPreferences.getBoolean("checkStated", false);

            if(checkShared == true){

                startActivity(new Intent(getApplicationContext(), log_in.class));
                finish();
            }
        }
    }

    @Override
    public void onSkipPressed(Fragment currentFragment) {
        super.onSkipPressed(currentFragment);
        // Do something when users tap on Skip button.

        startActivity(new Intent(getApplicationContext(), log_in.class));
        editor.putBoolean("checkStated", false).commit();
        finish();
    }

    @Override
    public void onDonePressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);
        // Do something when users tap on Done button.

        startActivity(new Intent(getApplicationContext(), log_in.class));
        editor.putBoolean("checkStated", true).commit();
        finish();
    }
}
