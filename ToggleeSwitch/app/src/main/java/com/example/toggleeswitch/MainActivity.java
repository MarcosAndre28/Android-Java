package com.example.toggleeswitch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private ToggleButton toggleButton;
    private CheckBox checkBox;
    private  Switch switchPassword;
    private TextView tvResult,tvResultToogle,tvResultCheck;
    private Button btSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toggleButton = findViewById(R.id.toggleButton);
        switchPassword = findViewById(R.id.password);
        checkBox = findViewById(R.id.checkBox);
        tvResult = findViewById(R.id.tv_result_switch);
        tvResultToogle = findViewById(R.id.tv_result_toogle);
        tvResultCheck = findViewById(R.id.tv_result_check);
        btSend = findViewById(R.id.bt_send);

        addListener();

        btSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                send();
                sendToogle();
                sendCheckBox();
            }
        });



    }
    public void send(){
        if (switchPassword.isChecked()){
            tvResult.setText("Swith ligado");
        }
        else {
            tvResult.setText("Swith Desligado");
        }
    }

    public void sendToogle(){
        if (toggleButton.isChecked()){
            tvResultToogle.setText("Toggle ligado");
        }
        else {
            tvResult.setText("Toggle Desligado");
        }
    }

    public void sendCheckBox(){
        if (checkBox.isChecked()){
            tvResultCheck.setText("CheckBox ligado");
        }
        else {
            tvResult.setText("CheckBox Desligado");
        }
    }

    private void  addListener(){
        // Funciona com toogle e switch tambem
        checkBox.setOnCheckedChangeListener((compoundButton, isChecked) -> {
            if (checkBox.isChecked()){
                tvResult.setText("Ligado");
            }
            else {
                tvResult.setText("Desligado");
            }
        });
    }
}