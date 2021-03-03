package com.example.twoactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView tvMessage;
    EditText txtReply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tvMessage = findViewById(R.id.tvMessage);
        txtReply = findViewById(R.id.txtReply);

        Intent intent = getIntent();

        String message = intent.getStringExtra("message");
        tvMessage.setText(message);
    }

    public void reply(View view) {
        String reply = txtReply.getText().toString();

        Intent intent = new Intent();
        intent.putExtra("reply", reply);

        setResult(Activity.RESULT_OK, intent);

        finish();
    }
}