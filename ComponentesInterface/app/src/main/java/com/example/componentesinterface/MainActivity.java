package com.example.componentesinterface;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button openDialog,loadingProgress,btSeekBar;
    ProgressBar progressBarHorizontal,loadingProgressCircular;
    SeekBar seekBar;
    TextView resultSeekbar;
    private int progress = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        openDialog = findViewById(R.id.open_dialog);
        loadingProgress = findViewById(R.id.bt_loading_progress);
        loadingProgressCircular = findViewById(R.id.progressBarCircular);
        btSeekBar = findViewById(R.id.bt_recovery);
        seekBar = findViewById(R.id.seekBar);
        resultSeekbar = findViewById(R.id.tv_resultES);

        progressBarHorizontal = findViewById(R.id.progressBar);
        loadingProgressCircular.setVisibility(View.GONE);

        seekBar();

        openDialog.setOnClickListener(view -> openDialog());
        loadingProgress.setOnClickListener(view -> loadingProgressBar());
        btSeekBar.setOnClickListener(view -> recpveryProgress());
    }

    private void openDialog() {
        // Instanciar AlertDialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        // Configurar titulo e mensagem
        builder.setTitle("Titulo da dialog");
        builder.setMessage("Mensagem da dialog");

        // Configurar cancelamento
        // True ele consegue cancelar, False ele não consegue
        builder.setCancelable(false);

        // Configurar icone
        builder.setIcon(R.drawable.ic_baseline);

        // Configura ações para sim e não
        builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Executar ação ap cliclar no botão SIM", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Executar ação ap cliclar no botão NÂO", Toast.LENGTH_SHORT).show();

            }
        });

        // Criar e exibir AlertDialog
        builder.create();
        builder.show();
    }
    private void loadingProgressBar(){
        // ProgressBar horizontal
        progressBarHorizontal.setProgress(progress = progress + 10);

        // ProgressBar Circular
        loadingProgressCircular.setVisibility(View.VISIBLE);
        if (progress == 100){
            loadingProgressCircular.setVisibility(View.GONE);
        }

    }
    private void  seekBar(){
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                resultSeekbar.setText("Progress: " + progress + " / " + seekBar.getMax());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //resultSeekbar.setText("onStartTrackingTouch");
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //resultSeekbar.setText("onStopTrackingTouch");
            }
        });
    }

    private void  recpveryProgress(){
        resultSeekbar.setText("Escolhido: " + seekBar.getProgress());
    }
}