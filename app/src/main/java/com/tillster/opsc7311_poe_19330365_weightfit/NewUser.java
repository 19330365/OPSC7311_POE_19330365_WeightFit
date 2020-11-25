package com.tillster.opsc7311_poe_19330365_weightfit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class NewUser extends AppCompatActivity {

    Button Continue, Logout;
    EditText CurrentWeight, CurrentHeight, GoalWeight, GoalHeight;
    Profile p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);

        Continue = findViewById(R.id.btnNContinue);
        CurrentHeight = findViewById(R.id.etCurrentHeight);
        CurrentWeight = findViewById(R.id.etCurrentWeight);
        GoalHeight = findViewById(R.id.etGoalHeight);
        GoalWeight = findViewById(R.id.etGoalWeight);



        Continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextActivity = new Intent(getApplicationContext(), BodyType.class);
                startActivity(nextActivity);

                p = new Profile(CurrentHeight.getText().toString(), CurrentWeight.getText().toString(), GoalHeight.getText().toString(), GoalWeight.getText().toString());

                Intent sendIntent = new Intent(Intent.ACTION_SEND);
                sendIntent.setType("text/plain");
                sendIntent.putExtra(Intent.EXTRA_TEXT, p.getCurrentHeight());
                startActivity(Intent.createChooser(sendIntent, "Show profile information"));

                        String currentWeight = CurrentWeight.getText().toString().trim();
                        String currentHeight = CurrentHeight.getText().toString().trim();
                        String goalWeight = GoalWeight.getText().toString().trim();
                        String goalHeight = GoalHeight.getText().toString().trim();

                if(TextUtils.isEmpty(currentWeight)){
                    CurrentWeight.setError("Please Input Current Weight");
                            return;
                        }
                        if(TextUtils.isEmpty(currentHeight)){
                            CurrentHeight.setError("Please Input Current Height");
                            return;
                        }
                            if(TextUtils.isEmpty(goalWeight)){
                                GoalWeight.setError("Please Input Your Goal Weight");
                                return;
                            }
                                if(TextUtils.isEmpty(goalHeight)){
                                    GoalHeight.setError("Please Input Current Height");
                                    return;
                                }

            }

        });
    }
    public void logout(View view){
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
        finish();
    }
}