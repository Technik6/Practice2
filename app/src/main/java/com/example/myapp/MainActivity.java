package com.example.myapp;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapp.R;
import com.example.myapp.SecondActivity;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private ActivityResultLauncher<Intent> launcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);


        launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                new MyActivityResultCallback());
    }

    public void onButtonClick(View view) {

        Intent intent = new Intent(this, SecondActivity.class);

        EditText editText = findViewById(R.id.editText);
        String textToSend = editText.getText().toString();

        intent.putExtra("textFromMainActivity", textToSend);

        launcher.launch(intent);
    }


    private class MyActivityResultCallback implements ActivityResultCallback<ActivityResult> {
        @Override
        public void onActivityResult(ActivityResult result) {
            if (result.getResultCode() == RESULT_OK) {
                Intent data = result.getData();
                String resultText = data.getStringExtra("resKey");
                textView.setText(resultText);
            }
        }
    }
}
