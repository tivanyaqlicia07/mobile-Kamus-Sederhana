package com.example.uaskamussederhana;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class EngToIndoActivity extends AppCompatActivity {

    private EditText editTextEng;
    private TextView textViewIndoResult;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eng_to_indo);

        editTextEng = findViewById(R.id.editTextEng);
        textViewIndoResult = findViewById(R.id.textViewIndoResult);
        Button buttonTranslateEng = findViewById(R.id.buttonTranslateEng);
        Button buttonBack = findViewById(R.id.buttonBack);

        databaseHelper = new DatabaseHelper(this);

        buttonTranslateEng.setOnClickListener(view -> {
            String wordEng = editTextEng.getText().toString().trim();
            String translation = databaseHelper.getTranslationEngToIndo(wordEng);

            if (translation != null) {
                textViewIndoResult.setText(translation);
            } else {
                textViewIndoResult.setText("Terjemahan tidak ditemukan");
            }
        });

        buttonBack.setOnClickListener(view -> {
            Intent intent = new Intent(EngToIndoActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }
}

