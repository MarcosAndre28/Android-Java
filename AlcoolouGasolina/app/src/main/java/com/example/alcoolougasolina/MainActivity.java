package com.example.alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    TextInputEditText editAlcool, editGasolina;
    Button btCalcular;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editAlcool = findViewById(R.id.edit_alcool);
        editGasolina = findViewById(R.id.edit_gasolina);
        btCalcular = findViewById(R.id.bt_calcular);
        tvResult = findViewById(R.id.tv_result);

        btCalcular.setOnClickListener(view -> theBest());

    }

    private void theBest(){
        String alcool = editAlcool.getText().toString();
        String gasolina = editGasolina.getText().toString();
        Boolean validate = validate(alcool, gasolina);
        if (validate){
            Double priceAlcool = Double.parseDouble(alcool);
            Double priceGasolina = Double.parseDouble(gasolina);

            Double result = priceAlcool / priceGasolina;
            if (result >= 0.7){
                tvResult.setText("Melhor Utilizar Gasolina");
            }else {
                tvResult.setText("Melhor Utilizar Àlcool");
            }


        }else {
            tvResult.setText("Preencha os preços primeiro");
        }

    }

    private Boolean validate(String pAlcool, String pGasolina){
        boolean isValidate = true;

        if (pAlcool == null || pAlcool.equals("")){
            isValidate = false;
        }else  if (pGasolina == null || pGasolina.equals("")){
            isValidate = false;
        }

        return  isValidate;

    }
}