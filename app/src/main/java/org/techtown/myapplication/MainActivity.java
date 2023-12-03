package org.techtown.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button expertButton = findViewById(R.id.expert_button);
        Button userButton = findViewById(R.id.user_button);

        expertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToSignUpPage(0);
            }
        });

        userButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToSignUpPage(1);
            }
        });
    }

    private void navigateToSignUpPage(int role){
        Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
        intent.putExtra("ROLE", role);
        startActivity(intent);
    }
}