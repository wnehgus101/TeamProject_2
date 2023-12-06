package org.techtown.myapplication;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import android.view.SurfaceHolder;
import android.view.SurfaceView;import android.hardware.Camera;
public class Call extends AppCompatActivity  implements SurfaceHolder.Callback{

    private FrameLayout videoContainer;
    private TextView peerNameTextView;
    private EditText messageEditText;
    private Button sendButton;
    private TextView textView;
    private List<String> chatHistory;
    private EditText editText;
    private Camera mCamera;
    private SurfaceView mSurfaceView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.call);

        editText = findViewById(R.id.messageEditText);
        textView = findViewById(R.id.txtView);
        chatHistory = new ArrayList<>();

        mSurfaceView = findViewById(R.id.surfaceView);
        SurfaceHolder surfaceHolder = mSurfaceView.getHolder();
        surfaceHolder.addCallback(this);

        Button sendButton = findViewById(R.id.sendButton);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage();
            }
        });
    }
    public void sendMessage() {
        String message = editText.getText().toString();
        chatHistory.add(message);
        updateChatHistory();
        editText.getText().clear();
    }

    private void updateChatHistory() {
        StringBuilder historyText = new StringBuilder();
        for (String message : chatHistory) {
            historyText.append(message).append("\n");
        }
        textView.setText(historyText.toString());
    }

    @Override
    public void surfaceCreated(@NonNull SurfaceHolder holder) {
        // 카메라 초기화 및 프리뷰 시작
        mCamera = Camera.open();

        try {
            mCamera.setPreviewDisplay(holder);
            mCamera.startPreview();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        // 프리뷰 사이즈 변경 시 호출
        // 여기에서 프리뷰 설정을 업데이트할 수 있음
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        // 액티비티가 종료되면 카메라 리소스 해제
        mCamera.stopPreview();
        mCamera.release();
    }
}
