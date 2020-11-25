package com.tillster.opsc7311_poe_19330365_weightfit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;

public class SetGoalType extends AppCompatActivity {

    ImageView ivMuscleGain, ivWeightLoss;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_goal_type);

        ivMuscleGain = findViewById(R.id.ivMuscleGain);
        ivWeightLoss = findViewById(R.id.ivWeightLoss);

        ivMuscleGain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
            }
        });

    }
    public void logout(View view){
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
        finish();
    }
}