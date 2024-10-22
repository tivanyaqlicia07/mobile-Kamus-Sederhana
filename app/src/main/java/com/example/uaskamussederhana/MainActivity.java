package com.example.uaskamussederhana;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonIndoToEng = findViewById(R.id.buttonIndoToEng);
        Button buttonEngToIndo = findViewById(R.id.buttonEngToIndo);

        buttonIndoToEng.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, IndoToEngActivity.class);
            startActivity(intent);
        });

        buttonEngToIndo.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, EngToIndoActivity.class);
            startActivity(intent);
        });
    }
}
