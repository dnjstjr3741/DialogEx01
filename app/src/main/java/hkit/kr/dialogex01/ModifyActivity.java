package hkit.kr.dialogex01;


import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ModifyActivity extends AppCompatActivity {

    EditText idEditText;
    EditText pwEditText;
    EditText emailEditText;

    Button modifyButton;
    Button closeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify);

        setTitle("수정 페이지");

        // 값을 전달 받기
        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        String pw = intent.getStringExtra("pw");
        String email = intent.getStringExtra("email");

        // 레이아웃과 연결하기
        idEditText = findViewById(R.id.idEditText);
        pwEditText = findViewById(R.id.pwEditText);
        emailEditText = findViewById(R.id.emailEditText);
        modifyButton = findViewById(R.id.modifyButton);
        closeButton = findViewById(R.id.closeButton);

        // 화면에 값 뿌려주기
        idEditText.setText(id);
        pwEditText.setText(pw);
        emailEditText.setText(email);

        // 버튼 이벤트 연결
        modifyButton.setOnClickListener(modifyListener);
        closeButton.setOnClickListener(closeListener);
    }

    View.OnClickListener modifyListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String id = idEditText.getText().toString();
            String pw = pwEditText.getText().toString();
            String email = emailEditText.getText().toString();


            Intent data = new Intent();
            data.putExtra("id",id);
            data.putExtra("pw",pw);
            data.putExtra("email",email);
            setResult(Activity.RESULT_OK,data);
            finish();
        }
    };

    View.OnClickListener closeListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            finish();
        }
    };
}