package com.example.snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    Button open,close;
    private Snackbar snackbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        open = findViewById(R.id.btn_open);
        close = findViewById(R.id.btn_close);

        open.setOnClickListener(view -> {
            snackbar = Snackbar.make(view, "Deu Certo",Snackbar.LENGTH_INDEFINITE).setAction("Confirmar", view1 -> open.setText("Sim"))
                    .setActionTextColor(getResources().getColor(R.color.purple_200));
            snackbar.show();

        });

        close.setOnClickListener(view -> snackbar.dismiss());

    }

}