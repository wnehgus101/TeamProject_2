package org.techtown.myapplication;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class ProSignUpTest extends AppCompatActivity {
    private ImageView imageView;

    private final ActivityResultLauncher<String> pickImageLauncher = registerForActivityResult(
            new ActivityResultContracts.GetContent(),
            new ActivityResultCallback<Uri>() {
                @Override
                public void onActivityResult(Uri result) {
                    if (result != null) {
                        // 선택된 이미지의 Uri를 처리
                        imageView.setImageURI(result);
                    }
                }
            }
    );

    private void openGallery() {
        // 갤러리에서 이미지를 선택하기 위한 코드
        pickImageLauncher.launch("image/*");
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

        choose_image_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openGallery();
            }
        });


    }
}
