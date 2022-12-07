package com.example.passingdatabetweenactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btn_sendData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_sendData = findViewById(R.id.btn_send_data);

        btn_sendData.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(),SegundActivity.class);
            User user = new User("Marcos","marcos@gmail.com");

            // Passando Dados
            intent.putExtra("name","Marcos");
            intent.putExtra("year",22);
            intent.putExtra("objeto",user);

            startActivity(intent);
        });
    }
}