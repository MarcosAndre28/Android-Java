package com.example.calculadoragorjeta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    SeekBar seekBar;
    TextView tvPortcen, tvGor, tvTotal;
    TextInputEditText editPrice;
    private double percentage = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar   = findViewById(R.id.seekBar);
        tvPortcen = findViewById(R.id.porcentagem);
        tvGor     = findViewById(R.id.tvGorjeta);
        tvTotal   = findViewById(R.id.tvTotal);
        editPrice = findViewById(R.id.editPrice);

        // Adicionar listener Seekbar

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                percentage = progress;
                tvPortcen.setText(Math.round(percentage) + " %");
                calculate();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    private void calculate() {
        String recoveryValue = editPrice.getText().toString();
        if (recoveryValue == null || recoveryValue.equals("")){
            Toast.makeText(this, "Digite um valor", Toast.LENGTH_SHORT).show();
        }else {
            // Vonverter string para double
            double value = Double.parseDouble(recoveryValue);

            // Calcular a gorjeta total
            double gorjeta = value * (percentage/100);
            double total = gorjeta + value;

            // Exibir a gorjeta e total
            // Math.round arredondar
            tvGor.setText("R$ " + Math.round(gorjeta));
            tvTotal.setText("R$ " + Math.round(total));
        }
    }
}