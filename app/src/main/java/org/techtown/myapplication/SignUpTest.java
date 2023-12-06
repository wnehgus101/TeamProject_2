package org.techtown.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignUpTest extends AppCompatActivity {
    private DataBaseHandler db_handler;

    @Override
    protected void onCreate(Bundle savedIntanceState) {
        super.onCreate(savedIntanceState);
        setContentView(R.layout.signup_test);

        //항목들 뷰들과 연결
        EditText user_id = findViewById(R.id.id);
        EditText user_pw = findViewById(R.id.pw);
        EditText user_name = findViewById(R.id.name);
        EditText user_contact = findViewById(R.id.contact);
        Spinner gender_spinner = findViewById(R.id.gender_spinner);
        Button confirm = findViewById(R.id.confirm);

        //전 엑티비티에서 넘겨준 값
        int user_type = getIntent().getIntExtra("user_type", -1);

        //만약에 0or 1이 아니라면 앱 종료됨
        if (user_type != 0 && user_type != 1) {
            Toast.makeText(this, "잘못된 사용자 유형입니다.", Toast.LENGTH_SHORT).show();
            finish();
        }

        //데이터베이스 객체 생성 및 연결
        db_handler = new DataBaseHandler(getApplicationContext());


        //성별 항목 가져오기
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.gender_array,
                android.R.layout.simple_spinner_item
        );

        //드롭다운 스타일 설정
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //스피너에 어뎁터 설정
        gender_spinner.setAdapter(adapter);

        //스피너 선택 이벤트
        gender_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String selected_gender = parentView.getItemAtPosition(position).toString();
                Toast.makeText(SignUpTest.this, selected_gender + "가 선택되었습니다.", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                Toast.makeText(SignUpTest.this, "성별을 선택해주세요", Toast.LENGTH_SHORT).show();
            }
        });

        //확인 버튼 누르는 경우
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //사용자 입력 가져 오기
                String userId = user_id.getText().toString().trim();
                String userPw = user_pw.getText().toString().trim();
                String name = user_name.getText().toString().trim();
                String contact = user_contact.getText().toString().trim();
                String gender = gender_spinner.getSelectedItem().toString();

                boolean dup = db_handler.isIDExists(userId); //아이디 중복 확인

                if (!dup) { //아이디 중복 아닌경우.
                    //입략값 데이터베이스에 저장
                    long result = db_handler.addUserData(userId, userPw, name, contact, gender, user_type);

                    int user_number = getLatestUserNumber();

                    if (result != 1) { //회원가입 성공 시에 추가 정보를 입력 받는 엑티비티로 이동한다.
                        Toast.makeText(SignUpTest.this, "회원가입 성공, 추가 정보를 입력해주세요.", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), ProSignUpTest.class);
                        intent.putExtra("user_number", user_number);
                        startActivity(intent);
                    } else { //회원가입 실패 시
                        Toast.makeText(SignUpTest.this, "회원가입 실패, 정보를 수정해주세요.", Toast.LENGTH_SHORT).show();
                    }
                } else { //아이디 중복인 경우.
                    Toast.makeText(SignUpTest.this, "아이디 중복, 재입력 해주세요.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private int getLatestUserNumber() {
        SQLiteDatabase db = db_handler.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT number FROM user_table ORDER BY number DESC LIMIT 1", null);

        int latestUserNumber = -1;  // 기본값 또는 오류 시 반환할 값

        int columnIndex = cursor.getColumnIndex("number");

        if (columnIndex >= 0) {
            if (cursor.moveToFirst()) {
                latestUserNumber = cursor.getInt(columnIndex);
            }

            // 커서를 닫음
            cursor.close();
        }
        return latestUserNumber;
    }
}