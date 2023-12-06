package org.techtown.myapplication;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;

public class ProSignUpTest extends AppCompatActivity {
    private ImageView imageView;
    private String image_path;
    private final ActivityResultLauncher<String> pickImageLauncher = registerForActivityResult(
            new ActivityResultContracts.GetContent(),
            new ActivityResultCallback<Uri>() {
                @Override
                public void onActivityResult(Uri result) {
                    if (result != null) {
                        // 선택된 이미지를 파일로 저장.
                        image_path = saveImageToFile(result);

                        // 이미지 뷰에 이미지 저장
                        imageView.setImageURI(result);
                    }
                }
            }
    );

    private void openGallery() {
        // 갤러리에서 이미지를 선택하기 위한 코드
        pickImageLauncher.launch("image/*");
    }

    private String saveImageToFile(Uri imageUri) {
        // 이미지 파일을 저장할 디렉토리 생성 (예: 앱 내부 파일 디렉토리)
        File directory = getApplicationContext().getFilesDir();

        // 이미지 파일 생성
        String imageName = "image_" + System.currentTimeMillis() + ".jpg";
        File imageFile = new File(directory, imageName);

        // 이미지 파일 저장
        try {
            InputStream inputStream = getContentResolver().openInputStream(imageUri);
            OutputStream outputStream = Files.newOutputStream(imageFile.toPath());
            byte[] buffer = new byte[1024];
            int bytesRead;
            while (true) {
                assert inputStream != null;
                if ((bytesRead = inputStream.read(buffer)) == -1) break;
                outputStream.write(buffer, 0, bytesRead);
            }
            inputStream.close();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 저장된 이미지 파일의 경로 반환
        return imageFile.getAbsolutePath();
    }
    @Override
    protected void onCreate(Bundle savedIntanceState){
        super.onCreate(savedIntanceState);
        setContentView(R.layout.prosignup_test);

        //사용할 객체 정의
        imageView = findViewById(R.id.pro_image);
        Button choose_image_button = findViewById(R.id.select_image);
        Button confirm = findViewById(R.id.confirm);
        TextView introduce = findViewById(R.id.introduce);
        TextView career = findViewById(R.id.career);
        TextView price = findViewById(R.id.price);
        TextView careable_pet = findViewById(R.id.careable_pet);

        DataBaseHandler db_handler = new DataBaseHandler(getApplicationContext());

        int user_number = getIntent().getIntExtra("user_number", -1);

        //만약에 0or 1이 아니라면 앱 종료됨
        if (user_number == -1) {
            Toast.makeText(this, "잘못된 사용자 유형입니다.", Toast.LENGTH_SHORT).show();
            finish();
        }

        //사진 선택 버튼 누르는 경우.
        choose_image_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openGallery();
            }
        });

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String intro = introduce.getText().toString().trim();
                String care = career.getText().toString().trim();
                String pri = price.getText().toString().trim();
                String careable = careable_pet.getText().toString().trim();

                long result = db_handler.addExpertData(image_path, care, intro, pri, careable, user_number);

                if (result != 1) { //회원가입 성공 시에 추가 정보를 입력 받는 엑티비티로 이동한다.
                    Toast.makeText(ProSignUpTest.this, "정보 입력 성공.", Toast.LENGTH_SHORT).show();
                } else { //회원가입 실패 시
                    Toast.makeText(ProSignUpTest.this, "정보 입력 실패.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
