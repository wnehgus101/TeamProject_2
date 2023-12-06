package org.techtown.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
public class inltialActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.initial_screen);

        // 각 버튼을 XML 파일에서 정의한 ID로 찾기
        Button patientButton = findViewById(R.id.button);
        Button doctorButton = findViewById(R.id.button2);
        Button loginButton = findViewById(R.id.button3);


        // 환자 버튼에 대한 클릭 리스너 설정
        patientButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 클릭될 때 수행할 동작 정의
                Intent intent = new Intent(inltialActivity.this, UserJoinActivity.class);
                startActivity(intent);


            }
        });

        // 의사 버튼에 대한 클릭 리스너 설정
        doctorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 클릭될 때 수행할 동작 정의
                Intent intent = new Intent(inltialActivity.this, DoctorJoinActivity.class);
                startActivity(intent);
            }
        });
        // 로그인 버튼 클릭 시 처리
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 로그인 처리
                // 예: Intent를 사용하여 로그인 액티비티로 이동
                Intent intent = new Intent(inltialActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}


