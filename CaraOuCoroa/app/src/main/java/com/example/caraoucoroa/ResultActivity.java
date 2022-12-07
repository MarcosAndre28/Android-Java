package com.example.caraoucoroa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ResultActivity extends AppCompatActivity {
        private Button btBack;
        private ImageView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        btBack = findViewById(R.id.bt_back);
        result =  findViewById(R.id.img_result);

        // Recuperar dados
        Bundle value = getIntent().getExtras();
        int number = value.getInt("number");

        if (number == 0){
            result.setImageResource(R.drawable.moeda_cara);
        }
        else {
            result.setImageResource(R.drawable.moeda_coroa);
        }


        btBack.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
            finish();
        });
    }
}