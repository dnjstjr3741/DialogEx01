package hkit.kr.dialogex01;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    final int REQUEST_CODE_MODIFY = 100;
    final int REQUEST_CODE_ADD = 101;

    TextView idTextView;
    TextView pwTextView;
    TextView emailTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("메인 페이지");

        // 레이아웃과 연결
        idTextView = findViewById(R.id.idTextView);
        pwTextView = findViewById(R.id.pwTextView);
        emailTextView = findViewById(R.id.emailTextView);

        Button modifyButton = findViewById(R.id.modifyButton);
        modifyButton.setOnClickListener(modifyListener);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 10){

            String id = data.getStringExtra("id");
            String pw = data.getStringExtra("pw");
            String email = data.getStringExtra("email");

            idTextView.setText(id);
            pwTextView.setText(pw);
            emailTextView.setText(email);
        }


    }

    View.OnClickListener modifyListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            // 화면에서 값을 읽어옴
            String id = idTextView.getText().toString();
            String pw = pwTextView.getText().toString();
            String email = emailTextView.getText().toString();

            Intent intent = new Intent(getBaseContext(), ModifyActivity.class);
            intent.putExtra("id",id);
            intent.putExtra("pw",pw);
            intent.putExtra("email",email);
            //startActivity(intent);
            startActivityForResult(intent, 10);
        }
    };
}
