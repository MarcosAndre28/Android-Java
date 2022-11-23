package com.example.componentesbasicos;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText editEmail, editName;
    private Button btnSend, btClear;
    private TextView tvResult, tvResultColor, tvResultSexo;
    private CheckBox checkBoxRed, checkBoxPurple, checkBoxGreen;
    private RadioButton radioButtonF, radioButtonM;
    private RadioGroup optionSexo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TextInputEditText
        editEmail = findViewById(R.id.edit_email);
        editName = findViewById(R.id.edit_name);

        // Button
        btnSend = findViewById(R.id.bt_send);
        btClear = findViewById(R.id.bt_clear);

        // TextView
        tvResult = findViewById(R.id.tv_result);
        tvResultColor = findViewById(R.id.tv_resultColor);
        tvResultSexo = findViewById(R.id.tv_sexo);

        // CheckBox
        checkBoxRed = findViewById(R.id.checkRed);
        checkBoxPurple = findViewById(R.id.checkPurple);
        checkBoxGreen = findViewById(R.id.checkGreen);

        // RadioButton
        radioButtonF = findViewById(R.id.rbF);
        radioButtonM = findViewById(R.id.rbM);
        optionSexo = findViewById(R.id.radioGroup);

        btnSend.setOnClickListener(view -> send());
        btClear.setOnClickListener(view -> clear());

        checkSexo();

    }

    @SuppressLint("SetTextI18n")
    private void send() {
        String name = editName.getText().toString();
        String email = editEmail.getText().toString();
        if (editName.getText().toString().trim().isEmpty()) {
            editName.setError("O nome é obrigatório");
            editName.requestFocus();
            return;
        }
        if (editEmail.getText().toString().trim().isEmpty()) {
            editEmail.setError("E-mail é obrigatório");
            editEmail.requestFocus();
            return;
        }

        String text = "";
        if (checkBoxGreen.isChecked()) {
            text = "Verde Selecionado";
            tvResult.setTextColor(getResources().getColor(R.color.green));
            tvResultColor.setTextColor(getResources().getColor(R.color.green));
        }
        if (checkBoxPurple.isChecked()) {
            text = "Purple Selecionado";
            tvResult.setTextColor(getResources().getColor(R.color.purple_500));
            tvResultColor.setTextColor(getResources().getColor(R.color.purple_500));
        }
        if (checkBoxRed.isChecked()) {
            text = "Vermelho Selecionado";
            tvResult.setTextColor(getResources().getColor(R.color.red));
            tvResultColor.setTextColor(getResources().getColor(R.color.red));
        }

        tvResultColor.setText(text);
        tvResult.setText("Nome: " + name + " E-mail: " + email);
    }

    private void clear() {
        editName.setText("");
        editEmail.setText("");
    }

    private void checkSexo() {

        optionSexo.setOnCheckedChangeListener((radioGroup, checkedId) -> {
            String sexo = "";

            if (checkedId == R.id.rbF){
                sexo = "Feminino";
            }
            else if (checkedId == R.id.rbM){
                sexo = "Masculino";
            }
            tvResultSexo.setText(sexo);
        });
    }
}