package com.example.talk2friends;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button registerButton, manageMeetingsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        registerButton = findViewById(R.id.registerButton);
        manageMeetingsButton = findViewById(R.id.manageMeetingsButton);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRegistrationActivity();
            }
        });

        manageMeetingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openManageMeetingsActivity();
            }
        });

    }

    private void openRegistrationActivity() {
        Intent intent = new Intent(this, RegistrationActivity.class);
        startActivity(intent);
    }

    private void openManageMeetingsActivity() {
        Intent intent = new Intent(this, MeetingManagerActivity.class);
        startActivity(intent);
    }
}
