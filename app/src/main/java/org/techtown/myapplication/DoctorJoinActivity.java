package org.techtown.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
public class DoctorJoinActivity extends AppCompatActivity{
    private boolean isIdDuplicate = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.doctor_join);

        EditText joinIdEditText = findViewById(R.id.join_id);
        EditText joinPasswordEditText = findViewById(R.id.join_password);
        EditText joinPwckEditText = findViewById(R.id.join_pwck);
        EditText joinNameEditText = findViewById(R.id.join_name);
        EditText joinPhoneEditText = findViewById(R.id.join_Phone);
        EditText joinSexEditText = findViewById(R.id.join_sex);
        EditText careerEditText = findViewById(R.id.career);
        EditText oneLineEditText = findViewById(R.id.one_line);
        EditText amountEditText = findViewById(R.id.amount);
        EditText availablePetsEditText = findViewById(R.id.available_pets);

        Button checkButton = findViewById(R.id.check_button);
        Button checkButton2 = findViewById(R.id.check_button2);
        Button completeButton = findViewById(R.id.complete);

        // 확인 버튼 클릭 시
        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 아이디 중복 확인 등의 동작을 수행
                if (isIdDuplicate) {
                    Toast.makeText(DoctorJoinActivity.this, "이미 사용 중인 아이디입니다.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(DoctorJoinActivity.this, "사용 가능한 아이디입니다.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // 사진 선택 버튼 클릭 시
        checkButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 갤러리에서 사진을 선택하는 동작을 수행
            }
        });

        // 완료 버튼 클릭 시
        completeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 회원가입을 완료하는 동작을 구현
                // 입력된 정보를 가져와 서버에 전송하거나 로컬 데이터베이스에 저장하는 등의 동작이 여기에 들어갈 수 있습니다.

                // 예시로 Toast 메시지를 통해 가입 완료 안내
                Toast.makeText(DoctorJoinActivity.this, "회원가입이 완료되었습니다.", Toast.LENGTH_SHORT).show();

                // 회원가입이 완료되었으므로 이전 화면으로 돌아가도록 할 수 있습니다.
                finish();
            }
        });
    }
}
