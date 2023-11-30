package org.techtown.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    private EditText loginIdEditText;
    private EditText loginPasswordEditText;
    private Button loginButton;
    private Button joinButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // XML에서 정의한 뷰들을 연결
        loginIdEditText = findViewById(R.id.login_id);
        loginPasswordEditText = findViewById(R.id.login_password);
        loginButton = findViewById(R.id.login_button);
        joinButton = findViewById(R.id.join_button);

        // 로그인 버튼 클릭 이벤트 처리
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 여기에 로그인 로직을 추가
                String userId = loginIdEditText.getText().toString();
                String password = loginPasswordEditText.getText().toString();

                // 예시: 간단한 예외처리 및 메시지 출력
                if (userId.isEmpty() || password.isEmpty()) {
                    showToast("아이디와 비밀번호를 모두 입력하세요.");
                } else {
                    // 로그인 성공 시 처리
                    showToast("로그인 성공");
                }
            }
        });

        // 회원가입 버튼 클릭 이벤트 처리
        joinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 여기에 회원가입 화면으로 이동하는 로직을 추가
                showToast("회원가입 화면으로 이동");
            }
        });
    }

    // 간단한 토스트 메시지를 표시하는 메소드
    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}

