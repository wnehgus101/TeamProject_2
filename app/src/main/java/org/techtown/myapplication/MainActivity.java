package org.techtown.myapplication;

<<<<<<< HEAD
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
=======
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
>>>>>>> 6fc3c4e7b4808af509ba2db910f61e7d8a0cda7e

import java.util.ArrayList;
import java.util.List;
public class MainActivity extends AppCompatActivity {
    //전문가와 사용자의 버튼에 따라서 0,1의 값을 넘기고 해당 엑티비티를 여는 함수
    private void startNextActivityWithValue(int user_types) {
        Intent intent = new Intent(MainActivity.this, SignUpTest.class);
        intent.putExtra("user_type", user_types);
        startActivity(intent);
    }

    CounselorFragment counselorFragment;
    QuestionnaireFragment questionnaireFragment;
    ScheduleFragment scheduleFragment;
    RecordFragment recordFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

<<<<<<< HEAD
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

        Button onlineCalling = findViewById(R.id.onlineCall);
        onlineCalling.setOnClickListener(new View.OnClickListener() { //화상통화 테스트 전환 버튼
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Call.class);
                startActivity(intent);
            }
        });

=======
        counselorFragment = new CounselorFragment();
        questionnaireFragment = new QuestionnaireFragment();
        scheduleFragment = new ScheduleFragment();
        recordFragment = new RecordFragment();

        getSupportFragmentManager().beginTransaction().replace(R.id.container, counselorFragment).commit();

        BottomNavigationView bottomNavigation = findViewById(R.id.menu_bottom_navigation);
        bottomNavigation.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        int itemId = item.getItemId();
                        if (itemId == R.id.tab1) {
                            Toast.makeText(getApplicationContext(), "첫번째 탭 선택됨", Toast.LENGTH_LONG).show();
                            replaceFragment(counselorFragment);
                            return true;
                        } else if (itemId == R.id.tab2) {
                            Toast.makeText(getApplicationContext(), "두번째 탭 선택됨", Toast.LENGTH_LONG).show();
                            replaceFragment(questionnaireFragment);
                            return true;
                        } else if (itemId == R.id.tab3) {
                            Toast.makeText(getApplicationContext(), "세번째 탭 선택됨", Toast.LENGTH_LONG).show();
                            replaceFragment(scheduleFragment);
                            return true;
                        } else if (itemId == R.id.tab4) {
                            Toast.makeText(getApplicationContext(), "네번째 탭 선택됨", Toast.LENGTH_LONG).show();
                            replaceFragment(recordFragment);
                            return true;
                        }

                        return false;
                    }
                }
        );
>>>>>>> 6fc3c4e7b4808af509ba2db910f61e7d8a0cda7e
    }

    private void replaceFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
    }
}
