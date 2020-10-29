package com.tillster.opsc7311_poe_19330365_weightfit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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

public class Registration extends AppCompatActivity implements View.OnClickListener
{
    private EditText name, surname, age, email, password;
    private Button registerUser;
    private TextView register;

    private FirebaseAuth mAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        mAuth = FirebaseAuth.getInstance();


        name = findViewById(R.id.etName);
        surname = findViewById(R.id.etSurname);
        age = findViewById(R.id.etAge);
        email = findViewById(R.id.etEmail);
        password = findViewById(R.id.etPassword);
        registerUser = findViewById(R.id.btnRegister);

    }

registerUser.setOnclickListener(new View.OnClickListener()
    @Override
    public void onClick(View v) {
        String nameInput = name.getText().toString().trim();
        String surnameInput = surname.getText().toString().trim();
        String ageInput = age.getText().toString().trim();
        String emailInput = email.getText().toString().trim();
        String passwordInput = password.getText().toString().trim();
        mAuth.createUserWithEmailAndPassword(emailInput, passwordInput).addOnCompleteListener(new OnCompleteListener<AuthResult>() {

            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(Registration.this, "User " + mAuth.getCurrentUser().getEmail() + "is Registered", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Registration.this, "Error occured, not registered", Toast.LENGTH_SHORT).show();
                }

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(Registration.this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        //Why registration error occured

    }
}
