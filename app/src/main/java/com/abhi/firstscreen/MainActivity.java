package com.abhi.firstscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnlogout(View view) {

        firebaseAuth.signOut();
        finish();
        startActivity(new Intent(getApplicationContext(), log_in.class));
        Toast.makeText(this, "Logged out", Toast.LENGTH_SHORT).show();
    }

}
