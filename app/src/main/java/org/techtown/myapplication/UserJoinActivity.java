package org.techtown.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
public class UserJoinActivity extends AppCompatActivity {
    private boolean isIdDuplicate = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_join);

        // 각각의 뷰 요소들을 참조합니다.
        EditText joinIdEditText = findViewById(R.id.join_id);
        EditText joinPasswordEditText = findViewById(R.id.join_password);
        EditText joinPasswordConfirmEditText = findViewById(R.id.join_pwck);
        EditText joinNameEditText = findViewById(R.id.join_name);
        EditText joinPhoneEditText = findViewById(R.id.join_Phone);
        EditText joinSexEditText = findViewById(R.id.join_sex);
        EditText petNameEditText = findViewById(R.id.career);
        EditText petAgeEditText = findViewById(R.id.one_line);
        EditText petSpeciesEditText = findViewById(R.id.amount);
        EditText petSexEditText = findViewById(R.id.available_pets);

        Button checkButton = findViewById(R.id.check_button);
        Button checkButton2 = findViewById(R.id.check_button2);
        Button checkInsertButton = findViewById(R.id.check_Insert);
        Button completeButton = findViewById(R.id.complete);

        ImageView petImageView = findViewById(R.id.imageView2);

        // 아이디 중복 확인 버튼 클릭 시
        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 아이디 중복 확인을 위한 동작을 구현
                // 중복 여부에 따라 사용자에게 메시지를 표시하거나 다음 단계로 진행
                // 예를 들어, 서버에 아이디 중복을 확인하는 API 호출 등이 여기에 들어갈 수 있습니다.
                if (isIdDuplicate) {
                    Toast.makeText(UserJoinActivity.this, "이미 사용 중인 아이디입니다.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(UserJoinActivity.this, "사용 가능한 아이디입니다.", Toast.LENGTH_SHORT).show();
                }
            }
        });


        // 반려동물 이미지 선택 버튼 클릭 시
        checkButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 갤러리에서 반려동물 이미지를 선택하는 동작을 구현
                // 이미지를 선택한 후 ImageView에 표시할 수 있습니다.
                // 예를 들어, 갤러리에서 이미지를 선택하는 인텐트를 띄우는 등의 동작이 여기에 들어갈 수 있습니다.
            }
        });

        // 의료 진단서 첨부하기 버튼 클릭 시
        checkInsertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 의료 진단서를 첨부하는 동작을 구현
                // 예를 들어, 갤러리에서 의료 진단서를 선택하는 인텐트를 띄우는 등의 동작이 여기에 들어갈 수 있습니다.
            }
        });

        // 완료 버튼 클릭 시
        completeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 회원가입을 완료하는 동작을 구현
                // 입력된 정보를 가져와 서버에 전송하거나 로컬 데이터베이스에 저장하는 등의 동작이 여기에 들어갈 수 있습니다.

                // 예시로 Toast 메시지를 통해 가입 완료 안내
                Toast.makeText(UserJoinActivity.this, "회원가입이 완료되었습니다.", Toast.LENGTH_SHORT).show();

                // 회원가입이 완료되었으므로 이전 화면으로 돌아가도록 할 수 있습니다.
                finish();
            }
        });
    }
}
