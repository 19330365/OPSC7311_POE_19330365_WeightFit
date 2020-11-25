package com.tillster.opsc7311_poe_19330365_weightfit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class BodyType extends AppCompatActivity {

    TextView Skinny, Regular, Extra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_body_type);

        Intent nextActivity = new Intent(getApplicationContext(), Home.class);
        startActivity(nextActivity);

        Skinny = findViewById(R.id.tvSkinny);
        Regular = findViewById(R.id.tvRegular);
        Extra = findViewById(R.id.tvExtra);

        Skinny.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String bodyType;
                if(Skinny.isSelected()){
                   bodyType = Skinny.toString();
                }
                else if(Regular.isSelected()){
                    bodyType = Regular.toString();
                }
                else if(Extra.isSelected()){
                    bodyType = Extra.toString();
                }
                return;
            }

            //StartA = new Intent(getApplicationContext(), Home.class);

        });

    }
    public void logout(View view){
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
        finish();
    }
}