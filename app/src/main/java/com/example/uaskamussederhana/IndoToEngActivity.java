package com.example.uaskamussederhana;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class IndoToEngActivity extends AppCompatActivity {

    private EditText editTextIndo;
    private TextView textViewEngResult;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indo_to_eng);

        editTextIndo = findViewById(R.id.editTextIndo);
        textViewEngResult = findViewById(R.id.textViewEngResult);
        Button buttonTranslateIndo = findViewById(R.id.buttonTranslateIndo);
        Button buttonBack = findViewById(R.id.buttonBack);

        databaseHelper = new DatabaseHelper(this);

        buttonTranslateIndo.setOnClickListener(view -> {
            String wordIndo = editTextIndo.getText().toString().trim();
            String translation = databaseHelper.getTranslationIndoToEng(wordIndo);

            if (translation != null) {
                textViewEngResult.setText(translation);
            } else {
                textViewEngResult.setText("Terjemahan tidak ditemukan");
            }
        });

        buttonBack.setOnClickListener(view -> {
            Intent intent = new Intent(IndoToEngActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }
}

