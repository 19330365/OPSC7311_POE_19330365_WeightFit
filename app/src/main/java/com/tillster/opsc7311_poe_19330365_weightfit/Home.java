package com.tillster.opsc7311_poe_19330365_weightfit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;

public class Home extends AppCompatActivity {

    ImageView UserProfile, Exercises, FoodDiary, DietaryTips;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        UserProfile = findViewById(R.id.ivProfile);
        Exercises = findViewById(R.id.ivExercises);
        FoodDiary = findViewById(R.id.ivDiary);
        DietaryTips = findViewById(R.id.ivDietary);

        UserProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent userInfo = new Intent(getApplicationContext(), NewUser.class);
                startActivity(userInfo);
            }
        });

        Intent exerciseSelect = new Intent(getApplicationContext(), WorkoutRoutines.class);
        startActivity(exerciseSelect);

        Exercises.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent exerciseSelect = new Intent(getApplicationContext(), WorkoutRoutines.class);
                startActivity(exerciseSelect);
            }
        });

        FoodDiary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent diaryLogInfo = new Intent(getApplicationContext(), DiaryLog.class);
                startActivity(diaryLogInfo);
            }
        });

        DietaryTips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent DietaryInfo = new Intent(getApplicationContext(), DietaryTips.class);
                startActivity(DietaryInfo);
            }
        });
    }
    public void logout(View view){
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
        finish();
    }
}