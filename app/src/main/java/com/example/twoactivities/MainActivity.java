package com.example.twoactivities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText txtMessage;
    TextView tvReply;

    private static final int REQUEST_CODE_REPLY = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtMessage = findViewById(R.id.txtMessage);
        tvReply = findViewById(R.id.tvReply);
    }

    public void sendMessage(View view) {
        String message = txtMessage.getText().toString();

        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("message", message);

        // do not expect result
//        startActivity(intent);

        // expect result
        startActivityForResult(intent, REQUEST_CODE_REPLY);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_CODE_REPLY) {
            if(resultCode == Activity.RESULT_OK) {
                String reply = data.getStringExtra("reply");
                tvReply.setText(reply);
            }
        }

    }
}