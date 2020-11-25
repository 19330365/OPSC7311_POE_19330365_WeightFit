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


public class Registration extends AppCompatActivity
{
    private EditText Name, Surname, Age, Email, Password;
    private Button registerUser;
    private FirebaseAuth mAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        Log.d("EB","Hit 2");

        Name = findViewById(R.id.etName);
        Surname = findViewById(R.id.etSurname);
        Age = findViewById(R.id.etAge);
        Email = findViewById(R.id.etEmail);
        Password = findViewById(R.id.etPassword);
        registerUser = (Button)findViewById(R.id.btnRegister);
        //registerUser.setOnClickListener(this);

        mAuth = FirebaseAuth.getInstance();

        Log.d("EB","Hit 3");
        //if(mAuth.getCurrentUser() != null){
            //startActivity(new Intent(getApplicationContext(), MainActivity.class));
            //finish();
        //}



        registerUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = Email.getText().toString().trim();
                String password = Password.getText().toString().trim();
                Toast.makeText(Registration.this, "button clicked", Toast.LENGTH_SHORT).show();

                if(TextUtils.isEmpty(email)){
                    Email.setError("Email is missing");
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    Password.setError("Password is missing");
                    return;
                }
                if(password.length() < 5){
                    Password.setError("Password must be <= 5 characters");
                    return;
                }

                mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(Registration.this, "User Created Successfully", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        }
                        else{
                            Toast.makeText(Registration.this, "Error!" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }

                    }
                });

            }
        });
    }

}




