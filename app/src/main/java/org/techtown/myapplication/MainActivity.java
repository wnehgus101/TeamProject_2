package org.techtown.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    //전문가와 사용자의 버튼에 따라서 0,1의 값을 넘기고 해당 엑티비티를 여는 함수
    private void startNextActivityWithValue(int user_types){
        Intent intent = new Intent(MainActivity.this, SignUpTest.class);
        intent.putExtra("user_type", user_types);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button imageButton = findViewById(R.id.profile);
        imageButton.setOnClickListener(new View.OnClickListener() { //프로필 ui 전환 버튼
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Profile.class);
                startActivity(intent);
            }
        });

        Button imageButton2 = (Button) findViewById(R.id.review); //누르면 상담 후기 화면 전환 버튼
        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Review.class);
                startActivity(intent);
            }
        });

        Button proSignUpTestButton = findViewById(R.id.signup_pro_test);
        proSignUpTestButton.setOnClickListener(new View.OnClickListener() { //전문가 회원가입 테스트 전환 버튼
            @Override
            public void onClick(View view) {
                startNextActivityWithValue(0);
            }
        });

        Button userSignUpTestButton = findViewById(R.id.signup_user_test);
        userSignUpTestButton.setOnClickListener(new View.OnClickListener() { //이용자 회원가입 테스트 전환 버튼
            @Override
            public void onClick(View view) {
                startNextActivityWithValue(1);
            }
        });
    }
}