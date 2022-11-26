package com.example.toast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btOpen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btOpen = findViewById(R.id.bt_open);
        btOpen.setOnClickListener(view -> open());

    }

    private void open(){

        // Toast Custom
        ImageView view = new ImageView(getApplicationContext());
        view.setImageResource(R.drawable.ic_launcher_foreground);

        TextView textView = new TextView(getApplicationContext());
        textView.setText("Olá Toast");
        textView.setBackgroundResource(R.color.purple_500);

        Toast toast = new Toast(getApplicationContext());
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(textView);
        toast.show();

        // Normal
        Toast.makeText(getApplicationContext(), "Ação realizada com sucesso", Toast.LENGTH_SHORT).show();
    }
}