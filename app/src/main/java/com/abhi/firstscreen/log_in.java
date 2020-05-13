package com.abhi.firstscreen;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class log_in extends AppCompatActivity {

    EditText txtEmail, txtPassword;
    Button btn_login;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        txtEmail = (EditText)findViewById(R.id.txt_email);
        txtPassword = (EditText)findViewById(R.id.txt_password);
        btn_login = (Button) findViewById(R.id.buttonLogin);

        firebaseAuth =FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);

        FirebaseUser user = firebaseAuth.getCurrentUser();

        if(user != null){
            finish();
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
        }

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = txtEmail.getText().toString().trim();
                String password = txtPassword.getText().toString().trim();


                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(log_in.this, "Please Enter Email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(log_in.this, "Please Enter Password", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (password.length() < 6) {
                    Toast.makeText(log_in.this, "Password too short", Toast.LENGTH_SHORT).show();
                }

                progressDialog.show();

                firebaseAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(log_in.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    progressDialog.dismiss();
                                    Toast.makeText(log_in.this, "Login Successful", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                                } else {

                                    Toast.makeText(log_in.this, "Login failed or User not Available", Toast.LENGTH_SHORT).show();
                                    progressDialog.dismiss();

                                }

                                // ...
                            }
                        });


            }
        });
    }

    public void btn_signupForm(View view) {

        startActivity(new Intent(getApplicationContext(),signup.class));
    }
}

