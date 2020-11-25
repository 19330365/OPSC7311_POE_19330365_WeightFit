package com.tillster.opsc7311_poe_19330365_weightfit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity<add> extends AppCompatActivity
{
    EditText Email, Password;
    Button Login;
    TextView Register, ForgotPassword;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        Register = (TextView) findViewById(R.id.txRegister);
        Email = findViewById(R.id.etEmail);
        Password = findViewById(R.id.etPassword);
        Login = findViewById(R.id.btnLogin);


        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerActivity = new Intent(getApplicationContext(), Registration.class);
                startActivity(registerActivity);

                Log.d("EB","Hit 1");
                //startActivity(new Intent(getApplicationContext(),Registration.class));
            }
        });

        Login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String email = Email.getText().toString().trim();
                String password = Password.getText().toString().trim();

                if(TextUtils.isEmpty(email)){
                    Email.setError("Email is missing");
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    Password.setError("Password is missing");
                    return;
                }
                if(password.length() < 5) {
                    Password.setError("Password must be <= 5 characters");
                    return;
                }



                mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                     if(task.isSuccessful()){
                         Toast.makeText(MainActivity.this, "Welcome", Toast.LENGTH_SHORT).show();
                         startActivity(new Intent(getApplicationContext(), Home.class));

                     }
                    }
                });
            }

    });


            }
        }








//Coding attribution
//----------------------------------------------
//Registration:
//Add the registration Feature
//https://youtu.be/i1h0EL7jNnQ
//----------------------------------------------
//login page:
//Add Login Feature
//https://youtu.be/DqSaEO3ZDwI
//----------------------------------------------
//Types of intent W3School, Implicit intent
//https://www.w3adda.com/android-tutorial/android-intents
//
//IntentsendIntent = newIntent();
//SendIntent.setAction(Intent.Action_Send);
//sendIntent.putExtra(IntentExtra_Text, Message);
//StartActivity(sendIntent);
//
//--------------------------------------------------------------
//Images used:
//
//Muscle Gain image: Weight training
//shorturl.at/pQY49
//
//pushup:Pinterest
//shorturl.at/kpGLP
//
//WeightLoss: One Step Towards Better Health | NARFA
//shorturl.at/auTV4
//
//bodyType: Free Body Type Calculator
//shorturl.at/otHXY
//
//cut/bulk: Reddit
// shorturl.at/kuxPV
//
//Profile:
//shorturl.at/couw3
//
//Diary:
//shorturl.at/hwHUV
//----------------------------------------------------