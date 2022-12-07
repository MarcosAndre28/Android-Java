package com.example.caraoucoroa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button btGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btGame = findViewById(R.id.button);

        btGame.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), ResultActivity.class);

            // Passar dados para próxima tela
            int number = new Random().nextInt(2); // 0 e 1
            intent.putExtra("number", number);

            startActivity(intent);
        });
    }
}