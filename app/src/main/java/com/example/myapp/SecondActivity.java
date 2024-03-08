package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        String newText = getIntent().getStringExtra("textFromMainActivity");


        TextView textView = findViewById(R.id.textView);
        textView.setText(newText);


        Intent resultIntent = new Intent();
        resultIntent.putExtra("resKey", newText);
        setResult(RESULT_OK, resultIntent);


        finish();
    }
}